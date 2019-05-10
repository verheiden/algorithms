package com.bff.library;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trie {
    TrieNode root;

   public  static void main(String[] args){
     Scanner terminal = new Scanner(System.in);
     Trie tree = new Trie();

     tree.load("April is beginning of Spring");
     tree.load("Atom is a unit of moracle");
     tree.load("April 1st is April fool's day");
     tree.load("Atom Bomb");
     tree.load("Nothing smells as nice as Citrus Blossoms");

     while(terminal.hasNext()){
        List<String> matches = tree.findCompletions(terminal.next());
        if ( matches == null ){
            System.out.println("No matches");
        }
        else
        {
            for(String line : matches)
            {
                System.out.println(line);
            }
        }
     }
    }

    public Trie(){
        root = new TrieNode(' ');
    }

    public void load(String sData){
        TrieNode node = root;
        for( int i = 0; i < sData.length(); i++){
            node = node.add(sData.charAt(i));
        }
        node.add('$');
    }

    public TrieNode matchPrefix(String prefix)
    {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            node = node.getChildNode(prefix.charAt(i));
            if ( node == null )
                return null;
        }
        return node;
    }
    public List<String> findCompletions(String prefix){
        TrieNode matchedNode  = matchPrefix(prefix) ;
         if ( matchedNode == null )  return null;

        List<String> completions = new ArrayList<String>();
        for(TrieNode child : matchedNode.getChildren())
        {
            findCompletetionsRecursive(child, prefix, completions);
        }
        return completions;
    }

    public void findCompletetionsRecursive(TrieNode node, String prefix,
        List<String> completetions)
    {
        if ( node == null )
            return ;
        if ( node.getChar() == '$'){
            completetions.add(prefix);
            return;
        }
        for( TrieNode child: node.getChildren()){
            findCompletetionsRecursive(child, prefix + node.getChar(), completetions);
        }
    }
}
