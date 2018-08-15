package basicAlgorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {

    private static int[] aux;//辅助函数


    /**
     * 将[l...r-1]与[r..rEnd]归并
     *
     * @param arr
     * @param l
     * @param r
     * @param rEnd
     */
    private static void merge(int arr[], int l, int r, int rEnd) {
        int temp = l;
        int lEnd = r - 1;

        //先将待排序两组子序列复制到辅助数组中
        for (int i = l; i <= rEnd; i++) {
            aux[i] = arr[i];
        }

        while (l <= lEnd && r <= rEnd) {
            if (aux[l] < aux[r]) {
                arr[temp++] = aux[l++];
            } else {
                arr[temp++] = aux[r++];
            }
        }

        //将另一边剩下的复制到原数组

        while (l <= lEnd) {
            arr[temp++] = aux[l++];
        }

        // (右边的不用复制吧,本来就在原数组)
        while (r <= rEnd) {
            arr[temp++] = aux[r++];
        }
    }

    /**
     * 自底向上的归并排序(递归写法)
     * @param arr
     * @param L
     * @param R
     */
    private static void mergeSort(int arr[], int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = (L + R) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        if (arr[mid] > arr[mid + 1]) {//如果左右已经有序则不归并
            merge(arr, L, mid + 1, R);
        }
    }


    /**
     * 自底向上的归并排序(迭代写法)
     *
     * @param arr
     */
    private static void mergeSortBU(int arr[]) {
        int n = arr.length;
        for (int size = 1; size < n; size = 2 * size) { //size 表示每次将2个size大小的序列归并成一个序列
            for (int i = 0; i + size < n; i = i + (size * 2)) {
                merge(arr, i, i + size, Math.min(i + (size * 2) - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {9, 8, 19, 6, 5, 3, 4, 2, 1};

        //初始化辅助数组
        aux = new int[array.length];

//        mergeSort(array, 0, array.length - 1);

        mergeSortBU(array);

        for (int a : array) {
            System.out.println(a);
        }
    }
}
