package com.example;


public class /* Print out a matrix dignally by Jung Verheiden */
diagnal {
    static final int[][] matrix = {{1,2,3,4,5,6}, { 7,8,9,10,11,12}, {13,14,15,16,17,18},{19,20,21,22,23,24}};
    public static void main(String[] args){


        printDiag(matrix);

    }

    public static void printDiag(int[][]  matrix) {

        int nRows = matrix.length - 1;
        int nCols = matrix[0].length - 1;
        int col = 0;
        int row = 0;
        int uCol =0;
        int uRow = 0;

        while (row <= nRows) {
            System.out.println('\n');
            uCol = Math.min(row, nCols);
            for (col = 0; col <= uCol; col++) {
                System.out.print(" " + matrix[row ][col]);
            }
            row++;
        }
        row = nRows;
        for(col =1; col <= nCols; col++ ) {
            System.out.println('\n');
            uRow = Math.min((nCols - col), nRows );
            for (int i = 0; i<= uRow; i++) {
                System.out.print(" " + matrix[row - i][col + i]);
            }
        }
    }
}
