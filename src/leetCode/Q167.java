package leetCode;

/**
 * 两数之和 II - 输入有序数组
 */
public class Q167 {
    public static int binarySearch(int[] arr, int l, int k) {
        // 在[l...r]中查找k
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

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, i + 1, target - numbers[i]);
            if (j != -1) {
                ret[0] = i + 1;
                ret[1] = j + 1;
            }
        }
        return ret;
    }


}
