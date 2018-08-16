package basicAlgorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int k) {
        // 在[l...r]中查找k
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int middle = l + ((r - l) >> 1);

            if (k == arr[middle])
                return middle;
            else if (k < arr[middle])
                r = middle - 1;
            else
                l = middle + 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 8, 9};

        int i = binarySearch(array, 7);

        System.out.println(i);
    }
}
