package basicAlgorithm.sort;

/**
 * 四种O(n^2)级别排序算法
 */

public class BasicSort {
    public static void main(String[] args) {
        int array[] = {9, 8, 7, 6, 5, 3, 4, 2, 1};

//        bubbleSort(array);

//        selectSort(array);

//        insertionSort(array);

//        shellSort1(array);

        shellSort2(array);

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


    /**
     * 1.冒泡排序
     * 每次在0～(n-1-i)中将最大的一步一步冒泡到最后
     *
     * @param arr
     */
    private static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean flag = false;//是否已经正序
        for (int i = 0; flag == false; i++) {
            flag = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
        }
    }

    /**
     * 2.选择排序
     * 每次从i～(n-1)找出最小元素放在最前面
     *
     * @param arr
     */
    private static void selectSort(int arr[]) {
        int n = arr.length;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            minIndex = i;//假定最小元素是第i个
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, minIndex, i);//把i～n中最小元素和第i位交换
        }
    }

    /**
     * 3.直接插入排序
     * 从第二个元素开始每次从向前 0～(i-1) 有序序列倒叙依次尝试自己合适的位置，直到比前一个元素大
     *
     * @param arr
     */
    private static void insertionSort(int arr[]) {
        int n = arr.length;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = arr[i];//待插入的元素
            int j = i;
            for (; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 4.希尔排序(缩小增量排序)
     *
     * @param arr
     */
    //严格按照定义来
    private static void shellSort1(int arr[]) {
        int n = arr.length;

        int h = n / 2;//初始增序起始
        while (h >= 1) {//获得增序序列并不断缩小h

            for (int k = 0; k < h; k++) {//扫描所有增序为h的序列的起始元素
                //然后对每一个序列重复进行插入排序
                int temp;
                for (int i = k + h; i < n; i += h) {
                    temp = arr[i];//待插入的元素
                    int j = i;
                    for (; j >= (k + h) && temp < arr[j - h]; j -= h) {
                        arr[j] = arr[j - h];
                    }
                    arr[j] = temp;
                }
            }

            h = h / 2;
        }

    }


    //优化版 直接交换
    private static void shellSort2(int arr[]) {
        int n = arr.length;

        int h = n / 2;//初始增序起始
        while (h >= 1) {//获得增序序列并不断缩小h

            int temp;
            for (int i = h; i < n; i++) {//从第一个h位元素开始，每次和所有前面与它相差h的元素序列做插入排序
                temp = arr[i];//待插入的元素
                int j = i;
                for (; j >= h && temp < arr[j - h]; j -= h) {//这里的h是 最大值而不是准确数字但该序列第二位一定大于等于h
                    arr[j] = arr[j - h];
                }
                arr[j] = temp;
            }

            h = h / 2;
        }

    }

}
