package exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaocong
 */
public class FindMax {
    private static int findMax(int[] array) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            } else if (array[mid] < array[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 5, 6, 5, 4, 4, 3, 2};
        int max = findMax(a);
        System.out.println(max);
    }
}