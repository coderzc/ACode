package basicAlgorithm.sort;

/**
 * 快速排序
 * pivot partition 基点分割
 */
public class QuickSort {
    public static void main(String[] args) {
        int array[] = {7, 6, 4, 10, 9, 2, 7, 7, 10, 6, 5, 1, 3, 4, 8, 1, 2, 3};

        quickSort(array);

        for (int a : array) {
            System.out.println(a);
        }
    }

    //基点中位数选取法(中位数法)
    private static int median3(int A[], int Left, int Right) {
        int Center = (Left + Right) / 2;
        if (A[Left] > A[Center])
            swap(A, Left, Center);
        if (A[Left] > A[Right])
            swap(A, Left, Right);
        if (A[Center] > A[Right])
            swap(A, Right, Center);
        return Center;
    }

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    //三路快排
    private static void quickSort3(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        // swap(array, l, ((int) Math.random() * (r - l) + l));
        swap(array, l, median3(array, l, r));
        int pivote = array[l];//基点放到最左边

        int lt = l;//[l+1...lt] < pivote
        int gt = r + 1;//[gt...r] > pivote
        int i = l + 1;//[lt+1..i) = pivote
        while (i < gt) {
            if (array[i] < pivote) {
                swap(array, lt + 1, i);
                lt++;
                i++;
            } else if (array[i] > pivote) {
                swap(array, gt - 1, i);
                gt--;
                // i 不用动因为交换过来的array[gt-1]不知道是什么情况;
            } else {
                i++;
            }
        }
        swap(array, lt, l);

        quickSort3(array, l, lt - 1);//[lt...gt-1] = pivote
        quickSort3(array, gt, r);
    }


    //单路快排
    private static void quickSort1(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        swap(array, l, ((int) Math.random() * (r - l) + l));
        int pivote = array[l];//基点放到最左边

        int j = l;//[l...i] < pivote
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < pivote) {
                swap(array, i, j + 1);
                j++;
            }
        }

        swap(array, j, l);

        quickSort1(array, l, j - 1);
        quickSort1(array, j + 1, r);
    }

    //双路快排
    private static void quickSort2(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        swap(array, l, ((int) (Math.random() * (r - l)) + l));
        int pivote = array[l];//基点放到最左边

        int i = l + 1;//左边比基点小的标志位
        int j = r;//右边比基点大的标志位
        while (true) {
            while (i <= r && array[i] < pivote) {
                i++;
            }
            while (j >= l + 1 && array[j] > pivote) {
                j--;
            }

            if (i > j) break;
            else swap(array, i++, j--);

        }

        swap(array, l, j);

        quickSort2(array, l, j - 1);
        quickSort2(array, j + 1, r);
    }

    //双路快排(严蔚敏版)
    private static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        swap(array, l, ((int) (Math.random() * (r - l)) + l));
        int pivote = array[l];//基点放到最左边

        int low = l;
        int hight = r;

        while (low < hight) {
            while (low < hight && array[hight] >= pivote) hight--;
            array[low] = array[hight];
            while (low < hight && array[low] <= pivote) low++;
            array[hight] = array[low];
        }

        array[low] = pivote;

        quickSort(array, l, low - 1);
        quickSort(array, low + 1, r);
    }

    private static void quickSort(int[] array) {
//        quickSort1(array, 0, array.length - 1);
//        quickSort2(array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);
//        quickSort3(array, 0, array.length - 1);
    }

}
