package com.example;

import java.util.ArrayList;

public class FullJustify {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<String>();
        FullJustify obj = new FullJustify();
/*        words.add("glu");
        words.add("muskzjyen");
        words.add("ahxkp");words.add("t");words.add("djmgzzyh");words.add("jzudvh");words.add("raji");words.add("vmipiz");words.add("sg");words.add("rv");words.add("mekoexzfmq");words.add("fsrihvdnt");words.add("yvnppem");words.add("gidia");words.add("fxjlzekp");words.add("uvdaj");words.add("ua");words.add("pzagn");words.add("bjffryz");words.add("nkdd");words.add("osrownxj");words.add("fvluvpdj");words.add("kkrpr");words.add("khp");words.add("eef");words.add("aogrl");words.add("gqfwfnaen");words.add("qhujt");words.add("vabjsmj");words.add("ji");words.add("f");words.add("opihimudj");words.add("awi");words.add("jyjlyfavbg");words.add("tqxupaaknt");words.add("dvqxay");words.add("ny");words.add("ezxsvmqk");words.add("ncsckq");words.add("nzlce");words.add("cxzdirg");words.add("dnmaxql");words.add("bhrgyuyc");words.add("qtqt");words.add("yka");words.add("wkjriv");words.add("xyfoxfcqzb");words.add("fttsfs");
        words.add("m");
        obj.fullJustify(words, 144);
      words.add("What");
        words.add("must");
        words.add("be");
        words.add("shall");
        words.add("be.");
        obj.fullJustify(words, 12);  */
        System.out.println(obj.trailingZeroes(5));
    }
    public int trailingZeroes(int a) {
        int tens = a;
        int decimals = 0;
        int trailingZero = 0;
        while( tens >= 10  )
        {
            decimals++;
            tens /= 10;
            trailingZero += decimals;
        }
        int fives = a/5;
        int twos = a/2;

        trailingZero += ( fives - decimals );
        return( trailingZero);
    }
    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> lines = new ArrayList<String>();
        int start = 0;
        int end = 0;
        int size = a.size();
        int i = 0;
        while( i < size )
        {
            int len = 0;
            start = i;

            int space = 0;
            while(( i < size ) )
            {
                int total = len + a.get(i).length() + space;
                total = len + a.get(i).length() + space;

                if ( total >= b ) {
                    if ( total == b ) {
                        end = i;
                        len += a.get(i).length();
                        i++;
                    }
                    break;
                }
                len += a.get(i).length();
                end = i;
                i++;
                space++;
            }
            int nWords = end - start + 1;
            int nSpaces = b - len;
            int extra = 0;
            int lastSpace = nSpaces;
            if ( nWords >  1)
            {
                nSpaces = ( b - len )/( nWords-1);
                extra =  (b - len) % (nWords -1 );
                lastSpace = 0;
            }
            if ( end == ( size -1 ))
            {
                nSpaces = 1;
                extra = 0;
                lastSpace = b - ( len + (nWords -1));
            }

            StringBuffer line = new StringBuffer();
            for( int j = start; j < end; j++)
            {
                line.append(a.get(j));
                space = nSpaces;
                while( space > 0 )
                {
                    line.append(' ');
                    space--;
                }
                if ( extra > 0)
                {
                    line.append(' ');
                    extra--;
                }
            }
            line.append(a.get(end));
            while( lastSpace > 0 )
            {
                line.append(' ');
                lastSpace--;
            }
            lines.add(line.toString());
        }
        return lines;
    }
}
