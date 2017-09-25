package com.example;

import java.util.Scanner;
/* Solution to find a pattern  within a grid of character matrix by Jung Verheiden */
public class GridSearch
{
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        int R, C, r, c;
        char[][] G;
        char[][] P;

        while (T-- > 0) {
            R = stdin.nextInt();
            C = stdin.nextInt();
            G = new char[R][C];
            for (int i = 0; i < R; i++) {
                String input = stdin.next();
                for (int j = 0; j < C; j++)
                    G[i][j] = input.charAt(j);
            }
            r = stdin.nextInt();
            c = stdin.nextInt();
            P = new char[r][c];
            for (int i = 0; i < r; i++) {
                String input= stdin.next();
                for (int j = 0; j < c; j++) {
                    P[i][j] = input.charAt(j);
                }
            }
            if (searchPattern(G, R, C, P, r, c))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean searchPattern(char[][] G, int R, int C, char[][] P, int r, int c)
    {
        for (int i = 0; i <= (R - r); i++) {

            for (int j = 0; j <= (C - c); j++) {
                boolean found = true;
                for (int k = 0; k < r; k++ )
                {
                    for (int l = 0; l < c; l++)
                    {
                        if (G[i + k][j + l] != P[k][l])
                        {
                            found = false;
                            break;
                        }
                    }
                    if ( found == false)
                        break;
                }
                if ( found == true)
                    return true;
            }
        }
        return(false);
    }
}
