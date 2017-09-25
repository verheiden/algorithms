

import java.util.Scanner;

public class AngryProfessor
{
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);
        String data = stdin.nextLine();
        int T = Integer.parseInt(data);
        int N , K;
        if ( ( T > 10 ) || ( T < 1 ))
        {
            System.out.println("Total case out of bound ");
            System.exit(-1);
        }
        while(T-- >= 1 )
        {
            if (stdin.hasNextLine())
            {
                data = stdin.nextLine();
                String[] pieces = data.split("\\s\\s");
                N = Integer.parseInt(pieces[0]);
                K = Integer.parseInt(pieces[1]);
                if ((N < 1) || (N > 1000)) {
                    System.out.println("Students in the class  number out of bound ");
                    System.exit(-1);
                }
                if ((K < 1) || (K > N))
                {
                    System.out.println("Cancellation threshold  number out of bound ");
                    System.exit(-1);
                }
                if (stdin.hasNextLine())
                {
                    data = stdin.nextLine();
                    pieces = data.split("\\s");
                    int I = pieces.length;
                    if ((I > N) || (I < 1)) {
                        System.out.println("Number of arrival times out of bound ");
                        System.exit(-1);
                    }
                    if (cancellation(pieces, N, K) == true) {
                        System.out.println("YES");
                    } else
                        System.out.println("NO");
                }
            }
        }
     }
        private static boolean cancellation(String[] times, int N, int K)
        {
              int onTime = 0;
              for(String stime:times)
              {
                  int  time = Integer.parseInt(stime);
                  if ( time <= 0 )
                  {
                      onTime++;
                      if ( onTime >= K )
                          return false;
                  }
              }
              return true;
        }
}
