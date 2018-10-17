package com.example.chenrui.game1942application;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Chucheng Qian, Rui Chen
 * Date: 17/10/2018
 */

public class AI {

    /**
     * Authors: Chucheng Qian, Rui Chen
     * Date: 17/10/2018
     */
    static Pos.Direction chasing(Pos posPacman ,Pos posGhost){
        Pos.Direction d;

        // Get the coordinate of pacman and ghost
        int pac_man_r = (int) (posPacman.y / (2 * Maze.offsetH));
        int pac_man_c = (int) (posPacman.x / (2 * Maze.offsetW));
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
            if (root.x == current.x && root.y == current.y) break;
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
     */
    Pos.Direction positionInFront(){
        //Todo, this is for ghost like Pinky
        return Pos.Direction.Down;
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
