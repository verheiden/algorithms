package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class uniquePrefix {


    public static void main(String[] args){
        ArrayList<String> input = new ArrayList<String>();
        input.add(new String( "bearcat"));
        input.add(new String( "bert"));
        uniquePrefix obj = new uniquePrefix();
        //ArrayList<String> out = obj.prefix(input);
        int result = obj.colorful(123);

    }
    public int colorful(int a)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        String rep = cString(a);
        int n = rep.length();
        for ( int len = 1; len <= n  ; len++)
        {

            for ( int i = 0; i <= (n - len); i++ )
            {
                int product = 1;
                for ( int j = i; j < i+len; j++ )
                {
                    product *= (int) ( rep.charAt(j)-'0');
                }
                if ( map.containsKey(product))
                    return 0;
                map.put(product, product);
            }
        }
        return (1) ;
    }

    String cString(int a)
    {
        StringBuffer buf = new StringBuffer();
        int num = a;
        int digit;

        while( num > 0 )
        {
            digit = num%10;
            num /= 10;
            buf.append((char) (digit + '0'));
        }
        buf.reverse();
        return buf.toString();
    }

    public ArrayList<String> prefix(ArrayList<String> a) {
        TrieTree tree = new TrieTree();
        if ( a == null )
            return null;
        ArrayList< String> res = new ArrayList<String>();
        for ( String k : a )
        {
            tree.load(k);
        }
        for ( String k: a )
        {
            res.add( tree.findPrefix(k));
        }
        return res;
    }
    class TrieTree
    {
        TrieNode root;
        public TrieTree(){
            root = new TrieNode(' ');
        }
        void load(String s)
        {
            TrieNode node = root;
            for ( int i =0; i < s.length(); i++ )
            {
                Character k = new Character(s.charAt(i));
                TrieNode cNode = node.child.get(k);
                if ( cNode  == null )
                {
                    cNode = new TrieNode(k);
                    node.child.put(k, cNode);
                }
                cNode.members++;
                node = node.child.get(k);
            }
        }
        String findPrefix(String s)
        {
            TrieNode node = root;
            StringBuffer prefix = new StringBuffer();
            for ( int i =0; i < s.length(); i++ )
            {
                char c = s.charAt(i);
                Character k = new Character(c);
                TrieNode cNode = node.child.get(k);
                if ( cNode == null )
                    return null;
                prefix.append(c);
                if ( (cNode.members == 1 )  )
                {
                    return prefix.toString();
                }
                node = cNode;
            }
            return prefix.toString();
        }
    }

    public class TrieNode
    {
        Character code;
        HashMap<Character, TrieNode> child;
        int members;
        public TrieNode(char a)
        {
            code = new Character(a);
            child = new HashMap<Character, TrieNode>();
            members = 0;
        }
    }

}
