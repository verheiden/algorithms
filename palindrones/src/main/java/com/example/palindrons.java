package com.example;

/*
** By Jung Verheiden, algorithm to count a number of palidrons within a given string.
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class palindrons {
    static public void main(String[] args){
        String a = new String("aabaacdeedcffjjkkkjjfflk");
        //String a = new String("hellolle");
        palindrons obj = new palindrons();
       /* System.out.println(" MinCuts : " + obj.minCuts(a)); */
       Map<String, String> ans = obj.cntPalindrons(a);
       for (Map.Entry<String, String> entry : ans.entrySet()){
            System.out.println(entry.getKey());
        }
    }
    


    HashMap<String, String> cntPalindrons(String a){
        boolean [][] dp = new boolean[a.length()][a.length()];
        HashMap<String, String> map = new HashMap<>();
        for( int i = 0; i < a.length(); i++){
            dp[i][i] = true;
        }
        int count = 0;
        try {
            for (int i = 0; i < a.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    if ((a.charAt(i) == a.charAt(j)) && ((i - j <= 1) || (dp[i - 1][j + 1] == true))) {
                        dp[i][j] = true;
                        if (i != j) {
                            count++;
                            StringBuffer s = new StringBuffer();
                            for (int k = j; k <= i; k++)
                                s.append(a.charAt(k));
                            String k = s.toString();
                            map.put(k, k);
                        }
                    }
                }
            }
        } catch(Exception e)
        {
            System.out.println("Exception" + e );
        }
        return map;
    }
}
