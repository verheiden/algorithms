package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

/*
** By Jung Verheiden, constant access to a member array to delte and add
*/

public class constAccess<T>
{

    Map<T, Integer> indexMap ;
    List<T> contents;
    Random random;
    public static void main(String[] args){
        constAccess<Integer> obj = new constAccess<Integer>();
        int i;
        for( i = 100; i <= 1000; i += 50){
            obj.add(i);
        }
        for ( i = 100; i <= 1000; i += 50 ){
            System.out.print(obj.deleteRandom() + " ");
        }
        System.out.println();
        if ( obj.size() != 0 )
        {
            System.out.println("DeleteRandom test failed.");
        }
        for( i = 100; i <= 1000; i += 50){
            obj.add(i);
        }
        for ( i = 100; i <= 1000; i += 50 ){
            System.out.print(obj.delete(i) + " ");
        }
        System.out.println();
        if ( obj.size() != 0 )
        {
            System.out.println("Delete() test failed.");
        }
    }


    public  constAccess()
    {
        indexMap = new HashMap<>();
        contents = new ArrayList<>();
        random = new Random();
    }
    public void add(T value){
        if ( !contents.contains(value)) {
            int index = contents.size();
            indexMap.put(value, index);
            contents.add(value);
        }
    }
    public T getRandom()
    {
        if ( !indexMap.isEmpty())
            throw new NoSuchElementException();
        int index  = random.nextInt(contents.size());
        return contents.get(index);
    }
    public T deleteRandom()
    {
        if ( indexMap.isEmpty()){
            throw new NoSuchElementException();
        }
        int index = random.nextInt(contents.size());
        return deleteValue(index);
    }
    public T delete(T delObj){
        if ( !contains(delObj))
        {
            throw new NoSuchElementException();
        }
        int index = indexMap.get(delObj);
        return deleteValue(index);
    }
    public boolean contains(T theObj){
        if ( theObj == null )
        {
            throw new NullPointerException();
        }
        return indexMap.containsKey(theObj);
    }
    public T deleteValue(int index)
    {
        T deleteObj =  contents.get(index);
        int lastIndex = contents.size() -1;
        T lastObj =  contents.get(lastIndex);
        contents.set(index, lastObj);
        contents.remove(lastIndex);
        indexMap.put(lastObj, index);
        indexMap.remove(deleteObj);
        return deleteObj;
    }
    public int size(){
        if ( contents.size() != indexMap.size()){
            throw new IllegalStateException();
        }
        return contents.size();
    }
}
