package com.example;

/*
** By Jung Verheiden, implement a memory cache algorithm based on the least frequently used
*    cache is deleted to create a new cache buffer.
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache<K, T> {
    static class Entry<K, T> {
        K key;
        T value;
        int hitCount;
        public Entry(K k, T val)
        {
            key = k;
            value = val;
            hitCount = 1;
        }
    }
    public static void main(String[] args){
        LFUCache<Integer, String>  obj = new LFUCache<>();
        String the = new String("The");
        String  first = new String("First");
        String is = new String("Is");
        String  what = new String("What");
        String you = new String("You");
        String think = new String("Think.");
        String about = new String("about");
        String ans;

        obj.set(111,the);
        obj.set(112, first);
        obj.set(113, is);
        obj.set(114, what);
        obj.set(115, you);
        for( int i = 111; i <= 115; i++)
        {
            ans = obj.get(i);
            if ( ans != null )
             System.out.println(ans);
        }
        for( int i = 111; i <= 113; i++){
            obj.get(i);
            obj.get(i);
        }
        for( int i = 114; i <= 115; i++){
            obj.get(i);
        }
        obj.set(114, think);
        obj.set(115, about);
        for( int i = 111; i <= 115; i++)
        {
            ans = obj.get(i);
            if ( ans != null )
                System.out.println(ans);
        }
    }
    private static final int CACHE_MAX = 5;
    Map<K, Entry<K, T>> cache = new HashMap<>();
    PriorityQueue<Entry<K,T>> cachePri = new PriorityQueue<Entry<K,T>> ( new Comparator<Entry<K,T>>(){
        public int compare(Entry<K,T> obj1, Entry<K,T>  obj2 )
        {
            return(obj1.hitCount - obj2.hitCount );
        }
    });
    public void set(K key, T content){
        if ( !cache.containsKey(key))
        {
            if ( cachePri.size() == CACHE_MAX)
            {
                Entry<K, T> lowest = cachePri.poll();
                cache.remove(lowest.key);
            }
        }
        Entry<K, T> entry = new Entry<>(key, content);
        cache.put(key, entry);
        cachePri.add(entry);
    }
    public T get(K key)
    {
        if ( cache.containsKey(key)){
            Entry<K,T> entry = cache.get(key);
            cachePri.remove(entry);
            entry.hitCount += 1;
            cachePri.add(entry);
            return entry.value;
        }
        return null;
    }
}
