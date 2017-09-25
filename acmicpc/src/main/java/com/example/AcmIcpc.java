

import java.util.Scanner;

/* Solution by Jung Verheiden for hacker ranker acmicpc problem */

public class AcmIcpc {
    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();

        if ((N > 500) || (N < 2)) {
            System.out.println("Number of people out  of bound ");
            System.exit(-1);
        }
        int M = stdin.nextInt();
        if ((M > 500) || (M < 0)) {
            System.out.println("Number of Topics  out of bound ");
            System.exit(-1);
        }
        String[] topics =  new String[N];

        for (int i = 0; i < N; i++) {
            topics[i] = stdin.next();
        }
        maxTopics(topics, N, M);
    }

    static void  maxTopics(String[] table, int N, int M)
    {
        int totalTopics;
        int maxTopics = 0;
        int people;
        int totalCouples = 0;
        for (people = 0; people < N; people++)
        {
            for (int partner = people + 1; partner < N; partner++)
            {
                totalTopics = 0;
                for (int topics = 0; topics < M; topics++) {

                    if (table[people].charAt(topics) == '1') {
                        totalTopics++;
                    } else {
                        if (table[partner].charAt(topics)  == '1')
                            totalTopics++;
                    }
                }
                if (totalTopics > maxTopics) {
                    maxTopics = totalTopics;
                }
            }
        }
        for (people = 0; people < N; people++)
        {
            for (int partner = people + 1; partner < N; partner++)
            {
                totalTopics = 0;
                for (int topics = 0; topics < M; topics++) {
                    if (table[people].charAt(topics) == '1') {
                        totalTopics++;
                    } else {
                        if (table[partner].charAt(topics) == '1' )
                            totalTopics++;
                    }
                }
                if (totalTopics == maxTopics) {
                    totalCouples++;
                }
            }
        }
        System.out.println(maxTopics);
        System.out.println(totalCouples);
    }
}

