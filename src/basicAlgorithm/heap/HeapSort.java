package basicAlgorithm.heap;

/**
 * 原地下沉堆排序
 */

public class HeapSort {
    public static void main(String[] args) {
        int array[] = {9, 8, 19, 6, 5, 3, 4, 2, 1};

        heapSort(array);


        for (int a : array) {
            System.out.println(a);
        }
    }

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void sink(int[] array, int n, int k) {//下沉
        while (2 * k + 1 <= n - 1) {
            int j = 2 * k + 1;//左孩子索引
            if (j + 1 <= n - 1 && array[j + 1] > array[j]) j++;//如果有右孩子并且右孩子比左孩子大 j 换成右孩子索引

            if (array[j] > array[k]) {
                swap(array, j, k);
                k = j;
            } else {
                break;
            }
        }
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        for (int i = (n - 1) / 2; i >= 0; i--) {//heapify 大根堆建成
            sink(array, n, i);
        }

        for (int j = n - 1; j > 0; j--) {
            swap(array, 0, j);//把最大的和最后以为交换
            sink(array, j, 0);
        }
    }
}
