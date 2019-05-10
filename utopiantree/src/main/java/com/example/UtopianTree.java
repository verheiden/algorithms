


import java.util.Scanner;

public class UtopianTree
{
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();

        if ((T > 10) || (T < 1)) {
            System.out.println("Total test case out of bound ");
            System.exit(-1);
        }

        while ( T-- > 0 )
        {
            int N = stdin.nextInt();
            if ((N > 60) || (N < 0)) {
                System.out.println("Number of  cycles out of bound ");
                System.exit(-1);
            }
            System.out.println(treeHeight(N));
        }
    }
    static int treeHeight(int Ncycles)
    {
        int height = 1;
        for ( int i = 1; i <= Ncycles; i++ )
        {
            if ( (i%2) == 1 )
            {
                  height = 2*height;
            }
            else
                height++;
        }
        return height;
    }
}
