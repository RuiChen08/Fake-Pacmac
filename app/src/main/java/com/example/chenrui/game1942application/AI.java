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
    static Pos.Direction chasing(Pos posPacman, Pos posGhost, intPos probingPos){
        Pos.Direction d;

        // Get the coordinate of pacman and ghost
        int pac_man_r = (int) (posPacman.y / (2 * Maze.offsetH));
        int pac_man_c = (int) (posPacman.x / (2 * Maze.offsetW));
        int ghost_r = (int) (posGhost.y / (2 * Maze.offsetH));
        int ghost_c = (int) (posGhost.x / (2 * Maze.offsetW));

        // If the ghost is too far away to from pac-man, it will try to get to different probing position until finding pac-man
        if (Math.abs(pac_man_r - ghost_r) <= 3 && Math.abs(pac_man_c - ghost_c) <= 3) {
            return BST(new intPos(ghost_r, ghost_c), new intPos(pac_man_r, pac_man_c));
        }
        else{
            Random random = new Random();
            while ((probingPos.x == ghost_r && probingPos.y == ghost_c) || Maze.maze[probingPos.x][probingPos.y] >= 3) {
                probingPos.x = random.nextInt(Maze.maze.length);
                probingPos.y = random.nextInt(Maze.maze[0].length);
            }
            return BST(new intPos(ghost_r, ghost_c), probingPos);
        }
    }

    /*
     * Author: Rui Chen, Ruiyi Sun
     * Date: 17/10/2018
     *
     * Predicting the position of pac-man and move in front to the pac-man
     */
    static  Pos.Direction positionInFront(Pos posPacman, Pos posGhost){

        int pac_man_r = (int) (posPacman.y / (2 * Maze.offsetH));
        int pac_man_c = (int) (posPacman.x / (2 * Maze.offsetW)) -((Maze.maze[0].length-(int) (posPacman.x / (2 * Maze.offsetW)))/5);
        int ghost_r = (int) (posGhost.y / (2 * Maze.offsetH));
        int ghost_c = (int) (posGhost.x / (2 * Maze.offsetW));

        return BST(new intPos(ghost_r, ghost_c), new intPos(pac_man_r, pac_man_c));
    }

    /*
     * Authors: Rui Chen
     * Date: 17/10/2018
     *
     * Description: Using the breadth first searching algorithm for find the path from ghost to pacman
     */
    static Pos.Direction BST(intPos root, intPos destination){
        Queue<intPos> queue = new LinkedList<>();
        Short[][] searching_status = new Short[Maze.maze.length][Maze.maze[0].length];

        intPos current = root;
        searching_status[root.x][root.y] = 1;
        while(true) {
            if (destination.x == current.x && destination.y == current.y) break;
            // Searching the 4 adjacent cell of the root coordinate
            if (Maze.maze[current.x - 1][current.y] <= 2 && searching_status[current.x - 1][current.y] == null){
                queue.offer(new intPos(current.x - 1, current.y, current == root ? null : current));
                searching_status[current.x - 1][current.y] = 1;
            }
            if (Maze.maze[current.x + 1][current.y] <= 2 && searching_status[current.x + 1][current.y] == null){
                queue.offer(new intPos(current.x + 1, current.y, current == root ? null : current));
                searching_status[current.x + 1][current.y] = 1;
            }
            if (Maze.maze[current.x][current.y + 1] <= 2 && searching_status[current.x][current.y + 1] == null){
                queue.offer(new intPos(current.x, current.y + 1, current == root ? null : current));
                searching_status[current.x][current.y + 1] = 1;
            }
            if (Maze.maze[current.x][current.y - 1] <= 2 && searching_status[current.x][current.y - 1] == null){
                queue.offer(new intPos(current.x, current.y - 1, current == root ? null : current));
                searching_status[current.x][current.y - 1] = 1;
            }
            current = queue.poll();
        }
        while (current.parent != null) current = current.parent;
        return (new Pos(root.y, root.x)).getDirection(new Pos(current.y, current.x));
    }

    /*
     * Author: Rui Chen
     * Date: 17/10/2018
     *
     * This is helping the BST algorithm for searching
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

        boolean closeTo(intPos destination) {
            return ((x + 1 == destination.x && y == destination.y) ||
                    (x - 1 == destination.x && y == destination.y) ||
                    (x == destination.x && y + 1 == destination.y) ||
                    (x == destination.x && y - 1 == destination.y));
        }
    }
}
