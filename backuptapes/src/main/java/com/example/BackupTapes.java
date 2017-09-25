package com.example;

public class
/*
** By Jung Verheiden, compute number of a minimum backup tapes when a series of file sizes and
*  the maximum capacity of a single tape.
*/
    BackupTapes {
    static public void main(String[] args){

        int[]  fileSizes =  new int[] { 1005, 10300, 4007, 123457, 13567, 123, 6780, 4578, 2893, 9999, 100234};
        System.out.println(new BackupTapes().countTapes(fileSizes, 15000));
    }

    public int countTapes(int[] files, int tapeCapacity)
    {
        int n = files.length;
        int numTapes = 0;
        int length = files[0];
        for ( int i = 1; i < n; i++){
            if ( length + files[i] < tapeCapacity )
            {
                length += files[i];
                if ( i == (n -1))
                {
                    numTapes++;
                }
            }
            else if ( length+files[i] == tapeCapacity )
            {
                numTapes++;
                length = 0;
            }
            else
            {
                numTapes++;
                length = files[i];
            }
        }
        return numTapes;
    }
}
