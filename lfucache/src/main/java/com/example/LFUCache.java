package com.example;

/*
** By Jung Verheiden, implement a memory cache algorithm based on the least frequently used
*    cache is deleted to create a new cache buffer.
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache{
    private static class Entry<K, T> {
        K key;
        T value;
        int hitCount;
        public Entry<K, T>(K ke, T va)
        {
            key = ke;
            value = va;
            hitCount = 1;
        }
    }
    private static final int CACHE_MAX = 5;
    Map<K, Entry<K, T>> cache = new HashMap<>();
    PriorityQueue<Entry<K, T>> cachePri = new PriorityQueue<Entry<K,T>>(
        new Comparator<Entry<K,T>>(){
            public int compare(Entry<K,T> a, Entry<K,T> b){
                return a.hitCount - b.hitCount;
            }
        });
    public void set(K ke, T va)
    {
        if ( !cache.contains(ke)) {
            if (cache.size() >= CACHE_MAX) {
                Entry<K, T> lowest = cachePri.poll();
                cache.remove(lowest.key);
            }
        }
        Entry<K,T> entry = new Entry<K,T>(ke, va);
        cache.put(K, entry);
        cachepri.add(entry);
    }
    public Entry<K,T> get(K ke)
    {
        if ( cache.containsKey(ke))
        {
            Entry<K,T> entry = cache.get(ke);
            cachePri.remove(entry)
            entry.hiCount++;
            cachePri.add(entry);
            return entry;
        }
        return null;
    }
    public void printall()
    {
       for(Map.Entry<K, T> entry : cache.entryset())
       {
           System.out.println(entry.getValue() + "   \n");
       }
    }
    public static void main(String[] args){
        LRUCache<Integer, String> lruCache = new LRUCache<>();
        String the = new String("the");
        String new = new String("new");
        String world = new String("world");
        String is = new String("is");
        String thrust = new String("thrust");
        String upon = new String("upon");
        String us = new String("us");
        String mine = new String("mine");

        lruCache.set(111, the);
        lruCache.set(222, new);
        lruCache.set(333, world);
        lruCache.set(444, is);
        lruCache.set(555, thrust);
        String word = lruCache.get(111);
        word = lruCache.get(222);
        lruCache.get(444);
        lruCache.set(666, upon);
        lruCache.get(222)
        lruCache.set(777, us);
        lruCache.set(888, mine);


        String word = lruCache.get(new);
        word = lruCache.get(world);
        lruCache.printall();
    }
}
