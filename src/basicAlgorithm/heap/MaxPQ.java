package basicAlgorithm.heap;

/**
 * 优先队列(大根堆)
 */
public class MaxPQ {

    private int[] pq;
    private int capacity;
    private int size;

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //BuildHeap
    public MaxPQ(int capacity) {
        pq = new int[capacity + 1];
        this.capacity = capacity;
        this.size = 0;
    }

    //Heapify
    public MaxPQ(int[] array) {
        pq = new int[array.length + 1];
        this.capacity = array.length;
        this.size = 0;
        for (int x : array) {
            pq[++size] = x;
        }
        for (int i = size / 2; i >= 1; i--)
            sink(i);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(int a) {
        pq[++size] = a;
        swim(size);
    }

    private void swim(int k) {//上浮
        while (k > 1 && pq[k / 2] < pq[k]) {
            swap(pq, k, k / 2);
            k = k / 2;
        }
    }

    public int delMax() {
        int max = pq[1];

        pq[1] = pq[size];
        pq[size--] = 0;

        sink(1);
        return max;
    }

    private void sink(int k) {//下沉
        while (2 * k <= size) {
            int j = 2 * k;//左孩子索引
            if (j + 1 <= size && pq[j + 1] > pq[j]) j++;//如果有右孩子并且右孩子比左孩子大 j 换成右孩子索引

            if (pq[j] > pq[k]) {
                swap(pq, j, k);
                k = j;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {2, 9, 10, 54, 9, 2, 7, 6, 5, 1, 3, 4, 8, 6};

        MaxPQ maxPQ = new MaxPQ(array.length);
        for (int x : array) {
            maxPQ.insert(x);
        }


//        MaxPQ maxPQ = new MaxPQ(array);

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = maxPQ.delMax();
        }


        for (int x : array) {
            System.out.println(x);
        }
    }

}