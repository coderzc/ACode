package basicAlgorithm.sort.merge;

/**
 * 自底向下的归并排序
 * 非递归式
 * 归并排序适用于链表
 */
public class MergeSortBU {
    private static int[] aux;

    public static void main(String[] args) {
        int array[] = {9, 8, 19, 6, 5, 3, 4, 2, 1};

        mergeSortBU(array);

        for (int a : array) {
            System.out.println(a);
        }
    }

    //将[l...mid]与[mid+1..r]归并
    private static void merge(int arr[], int l, int r, int rEnd) {
        int temp = l;
        int lEnd = r - 1;

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

        //将另一边剩下的复制到原数组(右边的不用复制吧将)

        while (l <= lEnd) {
            arr[temp++] = aux[l++];
        }

//        while (r<=rEnd){
//            arr[temp++]=aux[r++];
//        }
    }


    private static void mergeSortBU(int arr[]) {
        int n = arr.length;
        aux = new int[n];
        for (int size = 1; size < n; size += size) {
            for (int i = 0; i + size < n; i = i + (size * 2)) {
                merge(arr, i, i + size, Math.min(i + (size * 2) - 1, n - 1));
            }
        }
    }

}
