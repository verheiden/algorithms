package com.example;

import java.util.Scanner;

public class TwoStrings {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        reader.nextLine();

        while (N-- > 0) {
            String s1 = reader.nextLine();
            String s2 = reader.nextLine();
            if (s1.length() > s2.length()) {
                System.out.println(commonString(s1, s2));
            } else {
                System.out.println(commonString(s2, s1));
            }
        }

    }

    static String commonString(String longer, String shorter) {
        int len;
        int bit1 = 0, bit2 = 0;
        char[] s1 = longer.toCharArray();
        char[] s2 = shorter.toCharArray();

        for (int i = 0; i <= s1.length - 1; i++) {
            bit1 |= 1 << (s1[i] - 'a');
        }
        bit2 = bit1;
        for (int k = 0; k <= s2.length - 1; k++) {
            bit2 = bit1 & ((1 << (s2[k] - 'a')));
            if ( bit2 != 0 )
                return ("YES");
        }
        return("NO");
    }
}