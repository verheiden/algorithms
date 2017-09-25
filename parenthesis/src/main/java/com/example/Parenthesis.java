package com.example;

/*
** By Jung Verheiden, algorithm to determine whether a given expression contains
*   a valid number of parenthesis match.
*/
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args){
        boolean status = new Parenthesis().isValid(new String("{int[][] dp = new int[10][5];for((int i= 0); [(((i <n); i++))){ int k += i;}}"));
        if ( status )
            System.out.println("Valid Parenthesis.");
        else
            System.out.println("Invalid Parenthesis.");
    }

    boolean isValid(String a) {
        Stack<Character> pQueue = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            switch (c) {
                case '{':
                case '(':
                case '[':
                    pQueue.push(c);
                    break;
                case '}':
                    if (!pQueue.isEmpty() && pQueue.pop() == '{')
                        continue;
                    else
                        return false;
                case ')':
                    if (!pQueue.isEmpty() && pQueue.pop() == '(')
                        continue;
                    else
                        return false;

                case ']':
                    if (!pQueue.isEmpty() && pQueue.pop() == '[')
                        continue;
                    else
                        return false;
                default:
                    continue;
            }
        }
        if ( pQueue.isEmpty())
            return true;
        return false;
    }
}
