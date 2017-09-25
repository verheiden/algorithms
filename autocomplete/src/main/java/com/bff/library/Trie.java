package com.bff.library;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trie {
    TrieNode root;

       static public  void main(String args[])
       {
           Scanner input = new Scanner(System.in);
        Trie tree = new Trie();
        tree.load("The beautiful people");
        tree.load("The beautiful flowers");
        tree.load("The ugly garden is not beautiful");
        tree.load("The beautiful  people is me");
        while(input.hasNext())
        {
            String s = input.nextLine();
            List<String> autoC = tree.findCompletions(s);
            if (autoC != null)
            {
                for (String phrase : autoC) {
                    System.out.println(phrase);
                }
                System.out.println("\n\n");
            }
        }
    }

    public Trie(){
        root = new TrieNode(' ');
    }

    public void load(String sData){
        loadRecursive(root, sData + "$");
    }

    public void loadRecursive(TrieNode node, String sData)
    {
        if (isBlank(sData)){
            return;
        }
        char c = sData.charAt(0);
        node.add(c);
        TrieNode childNode = node.getChildNode(c);
        loadRecursive(childNode, sData.substring(1));
    }
    public boolean matchPrefix(String prefix)
    {
        TrieNode matchedNode = matchPrefixRecursive(root, prefix);
        return ( matchedNode  != null );
    }
    public TrieNode  matchPrefixRecursive(TrieNode node, String prefix)
    {
        if ( isBlank(prefix))
            return node;
        char c = prefix.charAt(0);
        TrieNode childNode = node.getChildNode(c);
        if ( childNode == null )
            return null;
        else
            return(matchPrefixRecursive(childNode, prefix.substring(1)) );
    }
    private boolean isBlank(String sData)
    {
        if ((sData == null) || (sData.length() == 0))
            return true;

        char[] cArray = sData.toCharArray();
        int l = cArray.length;

        for (int i = 0; i < l; i++)
        {
            char c = cArray[i];
            Character s = new Character(c);
            if ( !s.isWhitespace(c) )
                return false;
        }
        return true;
    }
    public List<String> findCompletions(String prefix){
        if ( matchPrefix(prefix) == false  )
            return null;
        TrieNode matchedNode = matchPrefixRecursive(root, prefix);
        List<String> completions = new ArrayList<String>();
        findCompletetionsRecursive(matchedNode, prefix, completions);
        return completions;
    }

    public void findCompletetionsRecursive(TrieNode node, String prefix,
        List<String> completetions)
    {
        if ( node == null )
            return;
        if ( node.getChar() == '$')
        {
            completetions.add(prefix.substring(0, prefix.length() - 1));
            return;
        }
        Collection<TrieNode> childNodes = node.getChildren();
        for ( TrieNode childNode : childNodes )
        {
            char childChar = childNode.getChar();
            findCompletetionsRecursive(childNode, prefix + childChar, completetions);
        }
    }
}
