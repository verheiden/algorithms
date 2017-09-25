package com.example;

/*
** By Jung Verheiden, algorithm to select first K number of words that are most repeated in an input
* array.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TopNWords {

   String[] words;
    private Comparator<WordInfo> com;

    public static void main(String[] args){
        String[] words = new String[] {"hello", "abc", "hello", "stupid", "stupid", "arrogant", "abc",
                "abc", "the", "first", "thing", "stupid", "first", "last", "abc"};
        ArrayList<String>ans =  new TopNWords().getNWords(words, 4 );

        for ( int i = 0; i < ans.size(); i++)
        {
            System.out.println(ans.get(i));
        }
    }
    ArrayList<String>   getNWords(String[] words, int N)
    {
        HashMap<String, WordInfo> base = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (base.containsKey(words[i])) {
                WordInfo w = base.get(words[i]);
                w.frequency++;
                base.put(words[i], w);
            } else
                base.put(words[i], new WordInfo(words[i]));
        }
        ArrayList<WordInfo> ans = new ArrayList<>();
        Iterator it = (Iterator) base.values().iterator();
        while (it.hasNext()) {
            WordInfo entry = (WordInfo) it.next();
            ans.add(entry);
        }
        Collections.sort(ans);
        ArrayList<String> res = new ArrayList<>();
        for ( int i = 0; i < N; i++)
        {
            res.add(ans.get(i).s);
        }
        return res;
     }

    class WordInfo implements Comparable<WordInfo>
    {
        String s;
        int frequency;
        public WordInfo(String a)
        {
            s = a;
            frequency = 1;
        }
        @Override
        public int compareTo(WordInfo o) {
                return o.frequency - frequency;
        }
    }
}
