package basicAlgorithm.sort.merge;

public class MergeSort {

    private static int[] aux;


    public static void main(String[] args) {
        int array[] = {9, 8, 19, 6, 5, 3, 4, 2, 1};

        mergeSort(array);

        for (int a : array) {
            System.out.println(a);
        }
    }


    //将[l...mid]与[mid+1..r]归并
    private static void merge(int arr[], int l, int r, int rEnd) {
        int n = arr.length;
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

    //对[L...R]进行二分归并
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

    private static void mergeSort(int arr[]) {
        aux = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }
}
