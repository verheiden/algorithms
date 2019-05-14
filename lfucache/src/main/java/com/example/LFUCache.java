package com.example;

/*
** By Jung Verheiden, implement a memory cache algorithm based on the least frequently used
*    cache is deleted to create a new cache buffer.
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LFUCache<K> {

    public static void main(String[] args) {
        LFUCache <String> lruCache = new LFUCache <String>();
        String the = new String("the");
        String New = new String("new");
        String world = new String("world");
        String is = new String("is");
        String thrust = new String("thrust");
        String upon = new String("upon");
        String us = new String("us");
        String mine = new String("mine");

        lruCache.set(the);
        lruCache.set(New);
        lruCache.set(world);
        lruCache.set(is);
        lruCache.set(thrust);

        lruCache.get(the);
        lruCache.get(New);
        lruCache.get(world);
        lruCache.set(upon);
        lruCache.get(thrust);
        lruCache.set(us);
        lruCache.set(mine);

        lruCache.printall();
    }

       public static class Entry<K> {
        int hitCount;
        K value;

        public Entry(K val) { value = val;  hitCount = 0; }
       }
       Map<K, Entry<K>> cache = new HashMap<>();

       public static final int CACHE_MAX = 5;
       PriorityQueue<Entry<K>>  cachePri = new PriorityQueue<Entry<K>>(new Comparator<Entry>(){
           public  int compare(Entry a, Entry b ) { return a.hitCount - b.hitCount; }
       });

       public void set(K k )
       {
           Entry entry;
           if ( !cache.containsKey(k)) {
               entry = new Entry(k);
               if ( cache.size()>= CACHE_MAX ) {
                   Entry<K> least = cachePri.poll();
                   cache.remove(least.value);
                   cachePri.remove(least);
               }
               cache.put(k, entry);
               cachePri.add(entry);
           }
           else {
               entry = cache.get(k);
           }
           entry.hitCount++;
       }

        public K  get(K ke)
        {
            if ( cache.containsKey(ke)) {
                Entry<K> entry = cache.get(ke);
                entry.hitCount++;
                return entry.value;
            }
            return null;
        }

        public void printall()
        {
            for ( Map.Entry<K, Entry<K>> entry : cache.entrySet()) {

                System.out.println(entry.getValue().value  + "   \n");
            }
        }
    }
