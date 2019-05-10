package com.bff.library;

import java.util.Collection;
import java.util.HashMap;
/*
 * Created by Jung Verheiden on May 10th 2019
 */

class TrieNode {
    Character character;
    HashMap<Character, TrieNode> children;
    TrieNode(char c)
    {
        character = new Character(c);
        children = new HashMap<>();
    }
    public TrieNode add(char c){
        Character index = new Character(c);
        if ( children.get(index) == null )
            children.put(index, new TrieNode(c));
           return children.get(index);  }
    public TrieNode getChildNode(char c) { return(children.get(new Character(c)));}
    public Collection<TrieNode> getChildren(){
        return children.values();
    }
    public char getChar() { return character.charValue();}
}

