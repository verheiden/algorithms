package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class winToZero {
    static List<Integer> boards;
    static public void  main(String[] args) {
        boards = new ArrayList<Integer>();

        boards.add(1);
        boards.add(3);
        boards.add(2);
        boards.add(0);
        boards.add(5);
        boards.add(2);
        boards.add(9);
        boards.add(4);
        boards.add(7);

        moveToWin(6);
        moveToWin(2);
        moveToWin(7);
    }
    static private void moveToWin(int position)
    {
        int index = position - 1;
        int numHops = boards.get(index);
        int size = boards.size() -1 ;
        int zeroP = boards.indexOf(0);
        int rights = 0;
        int lefts = 0;
        int distance = index - zeroP;
        int extraHops;
        if ( distance < 0 ) {
            rights = zeroP - index;
            extraHops = numHops - rights;
        }
        else
        {
            lefts = index - zeroP;
            extraHops = numHops - lefts;
        }

        if ( ( extraHops < 0 ) || (( extraHops%2) != 0) )
        {
            System.out.print(boards.get(index) + "cannot win\n");
            return;
        }
        System.out.println(boards.get(index) + "can wind : by "  );

        for( int i = 0; i < ( extraHops/2); i++)
        {
            if ( index == size ) {
                moveLeft();
                moveRight();
            }
            else
            {
                moveRight();
                moveLeft();
            }
        }
        while((lefts !=0))
        {
            moveLeft();
            lefts--;
        }
        while(rights != 0 )
        {
            moveRight();
            rights--;
        }
    }
    private static void moveLeft(){
        System.out.println("Move Left One Position");
    }
    private static void moveRight() {
        System.out.println("Move right One Position");
    }
}
