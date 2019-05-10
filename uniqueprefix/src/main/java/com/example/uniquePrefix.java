package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class uniquePrefix {


    public static void main(String[] args){
        ArrayList<String> input = new ArrayList<String>();
        input.add(new String( "bearcat"));
        input.add(new String( "bert"));
        uniquePrefix obj = new uniquePrefix();
        //ArrayList<String> out = obj.prefix(input);
        //int result = obj.colorful(123);
        obj.test1();

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
    ArrayList<String> test1()
    {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dot"));
        TrieTree1 obj = new TrieTree1();
        ArrayList<String> ans = obj.prefix(input);
        return ans;
    }
    class TrieTree1
    {
        TrieNode root;


        public ArrayList<String> prefix(ArrayList<String> a)
        {
            if ( a == null || a.size() == 0 )
                return a;
            root = new TrieNode();

            for(String s : a )
            {
                loadS(s);
            }

            ArrayList<String> ans = new ArrayList<String>();
            for( String s: a )
            {
                ans.add( findPrefix(s));
            }
            return ans;
        }

        void loadS(String s)
        {
            TrieNode node = root;

            for( int i = 0; i < s.length(); i++)
            {
                Character c = new Character(s.charAt(i));
                if (node.children.containsKey(c))
                {
                    node = node.children.get( c);
                }
                else
                {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
                node.members++;
            }
        }
        String findPrefix(String s)
        {
            TrieNode node = root;

            StringBuffer buf = new StringBuffer();
            for(int i = 0; i < s.length(); i++)
            {
                Character c = new Character(s.charAt(i));
                node = node.children.get( c);
                buf.append(c);
                if ( node.members == 1 )
                    return buf.toString();
            }
            return null;
        }
        class TrieNode
        {
            HashMap<Character, TrieNode> children;
            int members;

            public TrieNode()
            {
                children = new HashMap<Character,TrieNode>();
                members = 0;
            }
        }

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
