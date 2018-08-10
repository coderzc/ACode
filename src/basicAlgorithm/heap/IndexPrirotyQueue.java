package basicAlgorithm.heap;

import java.util.Comparator;

/**
 * 索引优先队列(最小索引堆)
 */
public class IndexPrirotyQueue<Item> {
    private final Comparator<? super Item> comparator;
    private Object[] pq;
    private int[] indexs;//存的是对应元素的索引，而进行jian du
    private int[] rev;//反查表 indexs[i]=j -> rev[j]=i -> rev[indexs[i]]=i -> index[rev[i]]=i
    private int capacity;
    private int size;

    //BuildHeap
    public IndexPrirotyQueue(int capacity) {
        this(capacity, null);
    }

    //BuildHeap
    public IndexPrirotyQueue(int capacity, Comparator<? super Item> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        this.size = 0;
        pq = new Object[capacity + 1];
        indexs = new int[capacity + 1];
        rev = new int[capacity + 1];
    }

    //Heapify
    public IndexPrirotyQueue(Item[] array) {
        this(array, null);
    }

    //Heapify
    public IndexPrirotyQueue(Item[] array, Comparator<? super Item> comparator) {
        this.capacity = array.length;
        pq = new Object[capacity + 1];
        indexs = new int[capacity + 1];
        rev = new int[capacity + 1];
        this.comparator = comparator;
        this.size = 0;
        for (Object x : array) {
            size++;
            pq[size] = x;
            indexs[size] = size;
            rev[size] = size;
        }
        for (int i = size / 2; i >= 1; i--)
            sink(i);
    }

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= capacity) throw new IndexOutOfBoundsException();
        return pq[i + 1] != null;
    }

    //入队
    public void offer(Item item) {
        int index = 0;//找空插入
        for (int i = 1; i < pq.length; i++) {
            if (pq[i] == null) {
                index = i;
                break;
            }
        }
        pq[index] = item;
        indexs[size + 1] = index;
        rev[index] = size + 1;
        size++;
        swim(size);

    }

    public void offer(int index, Item item) {
        if (contains(index)) throw new IllegalArgumentException("index is already in the priority queue");
        index++;
        pq[index] = item;
        indexs[size + 1] = index;
        rev[index] = size + 1;
        size++;
        swim(size);

//        System.out.println(Arrays.toString(pq));
//        System.out.println(Arrays.toString(indexs));
    }

    //出队
    @SuppressWarnings("unchecked")
    public Item poll() {
        Item item = (Item) pq[indexs[1]];

        pq[indexs[1]] = null;
        indexs[1] = indexs[size];
        indexs[size] = 0;
        rev[indexs[1]] = 1;
        rev[indexs[size]] = 0;

        size--;

        sink(1);
        return item;
    }

    @SuppressWarnings("unchecked")
    public Item peek() {
        Item item = (Item) pq[indexs[1]];
        return item;
    }

    @SuppressWarnings("unchecked")
    public int pollIndex() {
        int index = indexs[1] - 1;

        pq[indexs[1]] = null;
        indexs[1] = indexs[size];
        indexs[size] = 0;
        rev[indexs[1]] = 1;
        rev[indexs[size]] = 0;

        size--;

        sink(1);
        return index;
    }

    @SuppressWarnings("unchecked")
    public int peekIndex() {
        int index = indexs[1] - 1;
        return index;
    }

    //根据索引获取元素
    @SuppressWarnings("unchecked")
    public Item getItem(int i) {
        if (!contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        return (Item) pq[i + 1];
    }

    //修改索引i的item
    public void change(int i, Item newItem) {
        i++;
        pq[i] = newItem;

        int j = rev[i];
        swim(j);
        sink(j);
    }

    //上浮
    @SuppressWarnings("unchecked")
    private void swim(int k) {
        Comparable<? super Item> key = (Comparable<? super Item>) pq[indexs[k]];
        while (k > 1 && key.compareTo((Item) pq[indexs[k / 2]]) < 0) {
            swap(indexs, k, k / 2);
            rev[indexs[k / 2]] = k / 2;
            rev[indexs[k]] = k;
            k = k / 2;
        }
    }

    //下沉
    @SuppressWarnings("unchecked")
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;//左孩子索引
            Comparable<? super Item> key = (Comparable<? super Item>) pq[indexs[j]];
            if (j + 1 <= size && key.compareTo((Item) pq[indexs[j + 1]]) > 0) j++;//如果有右孩子并且右孩子比左孩子大 j 换成右孩子索引
            Comparable<? super Item> key2 = (Comparable<? super Item>) pq[indexs[j]];
            if (key2.compareTo((Item) pq[indexs[k]]) < 0) {
                swap(indexs, j, k);
                rev[indexs[j]] = j;
                rev[indexs[k]] = k;
                k = j;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Integer array[] = {2, 9, 10, 54, 9, 2, 7, 6, 5, 1, 3, 8, 6};

        IndexPrirotyQueue<Integer> pq = new IndexPrirotyQueue<>(array.length);

        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
        }

//        pq.poll();

//        pq.change(0,17);
//
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = pq.poll();
        }

        for (int x : array) {
            System.out.println(x);
        }
    }
}
