package com.example;

/*
** By Jung Verheiden, find the first unique character that is not repeated in the arrry.
*/
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    static public void main(String[] args){
        System.out.println(new FirstUniqueChar().unique1(new String("abcdefgabcdefgekkkllllolmn")));
    }
    char unique1(String a)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for( int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if ( map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        for( Character c : map.keySet()){
            if ( map.get(c) == 1)
                return c;
        }
        return '\0';
    }
}
