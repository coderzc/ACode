package tools;

import java.util.HashMap;

/**
 * @author zhaocong
 * Created on 2020-12-22
 */
public class LRUCache {

    static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private HashMap<Integer, Node> hashMap;
    private Node head;
    private Node tail;
    private int cap;

    LRUCache(int cap) {
        hashMap = new HashMap<>(cap);
        this.cap = cap;
    }

    public Integer get(int k) {
        Node node = hashMap.get(k);
        if (node != null) {
            afterNodeAccess(node);
            return node.val;
        } else {
            return null;
        }
    }

    public void put(int k, int v) {
        Node node = hashMap.get(k);
        if (node == null) {
            node = new Node(k, v);
            if (hashMap.size() >= cap) {
                dieOutNode();
            }
            hashMap.put(k, node);
        } else {
            node.val = v;
        }
        afterNodeAccess(node);
    }

    public int size() {
        return hashMap.size();
    }

    private void afterNodeAccess(Node node) {
        if (node.prev != null) {
            if(node.next==null){
                tail = node.prev;
            }
            node.prev.next = node.next;
            node.next = null;
        }
        Node first = head;
        head = node;
        head.next = first;
        if (first == null) {
            tail = node;
        }else {
            first.prev = head;
        }
    }

    private void dieOutNode() {
        Node dieOutNode = tail;
        hashMap.remove(dieOutNode.key);
        tail = tail.prev;
        if(tail!=null){
            tail.next = null;
        }
    }

    public void iteration() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.key + " --->" + cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        lruCache.put(2, 10);
        lruCache.get(1);
        lruCache.put(3, 10);
        lruCache.put(4, 10);
//        lruCache.put(5, 10);

        lruCache.iteration();
    }


}
