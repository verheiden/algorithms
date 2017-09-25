package com.example;

/*
** By Jung Verheiden, algorithm to determins if there is a path from a left,top most corner
*  to a right, bottom most corner given a two dimensional matrix of block or non-block cells.
*/
public class pathToCheese {
    int n;
    int m;
    int[][] maze;
    static public void main(String[] args){
        int[][] Maze = new int[][] {{1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 9, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println(new pathToCheese().test(Maze));


    }
    String test(int[][] maze)
    {
        n = maze[0].length-1;
        m = maze.length-1;
        this.maze  =  maze;
        boolean status = isPathToCheese(0,0);
        if ( status )
            return( new String("Yes"));
        else
            return ( new String("No"));
    }
    boolean isPathToCheese(int x, int y) {
        if (x < 0 || x > n || y < 0 || y > m)
            return false;
        if (maze[x][y] == 9)
            return true;
        if (maze[x][y] != 1)
            return false;
        if (maze[x][y] == 1)
            maze[x][y] = 3;
        if (isPathToCheese(x - 1, y))
            return true;
        if (isPathToCheese(x + 1, y))
            return true;
        if (isPathToCheese(x, y - 1))
            return true;
        if (isPathToCheese(x, y + 1))
            return true;
        return false;
    }
}
