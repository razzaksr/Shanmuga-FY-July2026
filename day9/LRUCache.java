package day9;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;
    public LRUCache(int cap){
        super(cap,0.75F,true);
        capacity = cap;
    }
    @Override
    protected boolean removeEldestEntry(
            Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
    public void put(int key,int value){
        super.put(key, value);
    }
    public int get(int key){
        return super.getOrDefault(key, -1);
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
