package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.sql.JDBCType.NULL;
import static sun.plugin2.message.JavaScriptSlotOpMessage.SET;
/* Solution to select only the unique strings from an array lists of words
 * by Jung Verheiden.
 */
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = null;
        right = null;
    }
}

public class repeatWords {

  Node root;
    static void main(String[] args)
    {

    }
    Set repeatWords1(String[] words){
        Set allWords = new HashSet<String>();
        Set repeatWords = new HashSet<String>();

        for(String word: words)
        {
            if ( allWords.add(word)== false )
            {
                repeatWords.add(word);
            }
        }
        return repeatWords;
    }
    Set repeatWords(String[] strings)
    {
        Set mySet = new HashSet<String>();
        Set dupSet = new HashSet<String>();
        for(String name: strings ) {
            if (mySet.add(name) == false) {
                dupSet.add(name);
            }
        }
        return ( dupSet);
    }

    boolean isAnagramS(String s1, String s2)
    {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return(Arrays.equals(array1, array2));
    }

    boolean isAnagramB(String s1, String s2)
    {
        String js1 = s1.replaceAll("\\s", "" );
        String js2 = s2.replaceAll("\\s", "");
        if ( js1.length() != js2.length())
            return false;
        char[] array1 = js1.toCharArray();
        StringBuffer sb = new StringBuffer(js2);
        for(char c: array1)
        {
            int index  = sb.indexOf("" + c);
            if ( index ==  -1 )
            {
                return false;
            }
            else
            {
                sb.deleteCharAt(index);
            }
        }
        return true;
    }

    public Node findLCA(int n1, int n2 )
    {
        if ( !findNode(root, n1))
            return null;
        if ( !findNode(root, n2))
            return null;
        return(findLCA(root, n1, n2));
    }
    private boolean findNode(Node root, int n)
    {
        if ( root == null )
            return false;
        if ( root.data == n )
            return true;
        if ( !findNode(root.left, n  ) )
            return(findNode(root.right, n));

    }
    private Node findLCA(Node root, int n1 , int n2 )
    {

        if ( root == null )
            return null;
        if ( ( root.data == n1 ) || ( root.data == n2 ))
        {
            return root;
        }
        if ( ( n1 > root.data ) && ( n2 > root.data ) )
            return( findLCA( root.right, n1, n2));
        else if ( (n1 < root.data) && ( n2 < root.data )))
            return( findLCA(root.left, n1,n2 ))
        return root;
    }

}
