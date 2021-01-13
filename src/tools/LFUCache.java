package tools;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author zhaocong
 * Created on 2020-12-22
 */
public class LFUCache {

    private int capacity;
    private int minFreq;
    private HashMap<Integer, Integer> valMap;
    private HashMap<Integer, Integer> keyToFreqMap;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    // 构造容量为 capacity 的缓存
    public LFUCache(int capacity) {
        this.valMap = new HashMap<>();
        this.keyToFreqMap = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;

    }

    // 在缓存中查询 key
    public int get(int key) {
        if (!valMap.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return valMap.get(key);
    }

    // 将 key 和 val 存入缓存
    public void put(int key, int val) {
        if(capacity == 0) {
            return;
        }
        if (valMap.containsKey(key)) {
            valMap.put(key, val);
            increaseFreq(key);
            return;
        }
        if (this.capacity <= valMap.size()) {
            removeMinFreq();
        }
        valMap.put(key, val);
        keyToFreqMap.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keys = freqToKeys.get(this.minFreq);
        Integer removeKey = keys.iterator().next();
        keys.remove(removeKey);
        if(keys.isEmpty()){
            freqToKeys.remove(this.minFreq);
        }
        valMap.remove(removeKey);
        keyToFreqMap.remove(removeKey);
    }

    private void increaseFreq(int key) {
        Integer freq = keyToFreqMap.get(key);
        keyToFreqMap.put(key, freq + 1);
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
            if(this.minFreq == freq){
                this.minFreq++;
            }
        }
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    public static void main(String[] args) {
        LFUCache lFUCache = new LFUCache(0);
        lFUCache.put(0,0);
        System.out.println(lFUCache.get(0));
//        lFUCache.put(1, 1);
//        lFUCache.put(2, 2);
//        lFUCache.get(1);      // 返回 1
//        lFUCache.put(3, 3);   // 去除键 2
//        lFUCache.get(2);      // 返回 -1（未找到）
//        lFUCache.get(3);      // 返回 3
//        lFUCache.put(4, 4);   // 去除键 1
//        lFUCache.get(1);      // 返回 -1（未找到）
//        lFUCache.get(3);      // 返回 3
//        lFUCache.get(4);      // 返回 4
    }
}
