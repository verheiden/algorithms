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
            if ( map.containsKey(a.charAt(i)))
                map.put(a.charAt(i), map.get(a.charAt(i)) +1  );
            else
                map.put(a.charAt(i), 1);
        }
        for(Character k: map.keySet())
        {
            if ( map.get(k) == 1 )
            {
                return k;
            }
        }
        return '\0';
    }
}
