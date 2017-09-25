package com.example;

/*
** By Jung Verheiden, find the first word in an array this is not repeated later in the array.
*/
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class firstNotRepeat {

    static public void main(String[] args){
          ArrayList<String> a = new ArrayList<>();
          a.add("The");
          a.add("first");
          a.add("love");
          a.add("is")  ;
          a.add("not");
          a.add("The");
          a.add("first");
          a.add("love");
          a.add("then");
          a.add("She");
          a.add("is");
          a.add("lucky");

          System.out.println( new firstNotRepeat().firstNotRepeated(a));
    }
    String firstNotRepeated(ArrayList<String> a)
    {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : a){
            if ( !map.containsKey(s))
            {
                map.put(s, 1);
            }
            else
            {
                map.put(s, map.get(s) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            String key = entry.getKey();
            if ( entry.getValue() == 1 )
                return key;
        }
        return null;
    }
}
