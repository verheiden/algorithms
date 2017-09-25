package com.example;

/*
** By Jung Verheiden, format the words in an array to be a given length line
** each line right justifies.
*/
import java.util.ArrayList;

public class formatLlength {
    static public void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add(new String("what"));
        words.add(new String("must"));
        words.add(new String("be"));
        words.add(new String("shall"));
        words.add(new String("be."));

        new formatLlength().fullJustify(words, 12);
    }

    public ArrayList<String> fullJustify(ArrayList<String> a, int b)
    {

        if (a == null || b == 0)
            return null;

        ArrayList<String> res = new ArrayList<String>();

        int i = 0;
        int n = a.size();
        while (i < n) {
            int length = 0;
            int numWords = 0;
            int start = i;
            int finalSpaces = 0;
            while (i < n && (length + a.get(i).length() + numWords) <= b) {
                length += a.get(i).length();
                numWords++;
                i++;
            }
            int spaces = b - length;
            int extra = 0;
            if (numWords > 1) {
                extra = spaces % (numWords - 1);
                spaces /= (numWords - 1);
            }
            if (i == n) {
                extra = 0;
                finalSpaces = b - length - numWords + 1;
                spaces = 1;
                if (numWords == 1)
                    finalSpaces -= 1;
            }
            StringBuffer line = new StringBuffer();
            int lastWords = start + numWords - 1;
            for (int j = start; j < start + numWords; j++) {
                line.append(a.get(j));
                if ((numWords == 1 || j < lastWords)) {
                    for (int k = 0; k < spaces; k++) {
                        line.append(' ');
                    }
                    if (extra > 0) {
                        line.append(' ');
                        extra--;
                    }
                }
            }
            for (int k = 0; k < finalSpaces; k++) {
                line.append(' ');
            }
            res.add(line.toString());
        }
        return res;
    }

}
