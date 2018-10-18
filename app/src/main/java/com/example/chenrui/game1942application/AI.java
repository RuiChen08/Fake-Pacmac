package com.example.chenrui.game1942application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Author: Chucheng Qian, Rui Chen
 * Date: 17/10/2018
 */

public class AI {

    /**
     * Authors: Chucheng Qian, Rui Chen
     * Date: 17/10/2018
     */
    Pos.Direction movingAI(Pos posPacman, Pos posGhost, intPos probingPos, String strategy){
        // Get the coordinate of pacman and ghost
        int pac_man_r = (int) (posPacman.y / (2 * Maze.offsetH));
        int pac_man_c = (int) (posPacman.x / (2 * Maze.offsetW));
        int ghost_r = (int) (posGhost.y / (2 * Maze.offsetH));
        int ghost_c = (int) (posGhost.x / (2 * Maze.offsetW));

        // If the ghost is too far away to from pac-man, it will try to get to different probing position until finding pac-man
        if (strategy.equals("chasing")) {
            if (Math.abs(pac_man_r - ghost_r) <= 3 && Math.abs(pac_man_c - ghost_c) <= 3) {
                probingPos.x = pac_man_r;
                probingPos.y = pac_man_c;
            }
        } else if (strategy.equals("escaping")){
            if (Math.abs(pac_man_r - ghost_r) <= 3 && Math.abs(pac_man_c - ghost_c) <= 3) {
                probingPos.x = pac_man_r > ghost_r ? 1 : Maze.MAZE.length - 2;
                probingPos.y = pac_man_c > ghost_c ? 1 : Maze.MAZE[0].length - 2;
            }
        }

        //Randomly choose a probing position
        while ((probingPos.x == ghost_r && probingPos.y == ghost_c) || Maze.MAZE[probingPos.x][probingPos.y] >= 3) {
            Random random = new Random();
            probingPos.x = random.nextInt(Maze.MAZE.length);
            probingPos.y = random.nextInt(Maze.MAZE[0].length);
        }
        return BFS(new intPos(ghost_r, ghost_c), probingPos, Maze.MAZE);
    }

    /*
     * Authors: Rui Chen
     * Date: 17/10/2018
     *
     * Description: Using the breadth first searching algorithm for find the path from ghost to pacman
     */
    public static Pos.Direction BFS(intPos root, intPos destination, short[][] maze){
        Queue<intPos> queue = new LinkedList<>();
        Short[][] searching_status = new Short[maze.length][maze[0].length];

        intPos current = root;
        searching_status[root.x][root.y] = 1;
        while(true) {
            if (destination.x == current.x && destination.y == current.y) break;
            // Searching the 4 adjacent cells of the root coordinate
            if (maze[current.x - 1][current.y] != 3 && searching_status[current.x - 1][current.y] == null){
                queue.offer(new intPos(current.x - 1, current.y, current == root ? null : current));
                searching_status[current.x - 1][current.y] = 1;
            }
            if (maze[current.x + 1][current.y] != 3 && searching_status[current.x + 1][current.y] == null){
                queue.offer(new intPos(current.x + 1, current.y, current == root ? null : current));
                searching_status[current.x + 1][current.y] = 1;
            }
            if (maze[current.x][current.y + 1] != 3 && searching_status[current.x][current.y + 1] == null){
                queue.offer(new intPos(current.x, current.y + 1, current == root ? null : current));
                searching_status[current.x][current.y + 1] = 1;
            }
            if (maze[current.x][current.y - 1] != 3 && searching_status[current.x][current.y - 1] == null){
                queue.offer(new intPos(current.x, current.y - 1, current == root ? null : current));
                searching_status[current.x][current.y - 1] = 1;
            }
            current = queue.poll();
        }
        // Keep looking for it parents until it found the root
        while (current.parent != null) current = current.parent;
        return (new Pos(root.y, root.x)).getDirection(new Pos(current.y, current.x));
    }

    /*
     * Author: Rui Chen
     * Date: 17/10/2018
     *
     * This class is for helping the BFS algorithm for searching
     */
    static class intPos{
        int x;
        int y;
        intPos parent;

        intPos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        intPos(int x, int y, intPos parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
    }
}
