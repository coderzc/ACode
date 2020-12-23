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

    public Integer get(int key) {
        Node node = hashMap.get(key);
        if (node != null) {
            afterNodeAccess(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (hashMap.size() >= cap) {
                dieOutNode();
            }
            hashMap.put(key, node);
        } else {
            node.val = value;
        }
        afterNodeAccess(node);
    }

    public int size() {
        return hashMap.size();
    }

    private void afterNodeAccess(Node node) {
        Node lastFirst = head;
        if (lastFirst == null) {
            head = tail = node;
            return;
        }
        if (node.key == lastFirst.key) {
            return;
        }

        Node prevNode = node.prev;
        Node nextNode = node.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
            node.next = null;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
            node.prev = null;
        }

        if (prevNode != null && nextNode == null) {
            tail = prevNode;
        }

        head = node;
        head.next = lastFirst;
        lastFirst.prev = head;
    }

    private void dieOutNode() {
        Node dieOutNode = tail;
        hashMap.remove(dieOutNode.key);
        System.out.println("remove key :" + dieOutNode.key);
        tail = tail.prev;
        if (tail != null) {
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

    /**
     * ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
     * [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));

        lruCache.iteration();
    }


}
