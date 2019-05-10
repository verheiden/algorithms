package com.bff.library;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by jung on 3/9/17.
 */

public class TrieNode
{
    Character code;
    HashMap<Character, TrieNode > children;
    public TrieNode(char c)
    {
        code = new Character(c);
        children = new HashMap<Character, TrieNode>();
    }
    public char getChar()
    {
        return code.charValue();
    }
    public Collection<TrieNode> getChildren()
    {
        return children.values();
    }
    public void add(char c)
    {
        if ( children.get(new Character(c)) == null ){
            children.put( new Character(c), new TrieNode(c));
        }
    }
    public TrieNode getChildNode(char c)
    {
        return children.get(new Character(c));
    }
    public boolean contains(char c)
    {
        return( children.get(new Character(c)) != null );
    }
}
