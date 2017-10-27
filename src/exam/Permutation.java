package exam;
/**
 * 全排列
 */

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] array2 = {1, 1, 2};
        Permutation(array2, 0);
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void Permutation(int[] array, int start) {
        if (start == array.length - 1) {
            System.out.println(Arrays.toString(array));
        }

        for (int i = start; i < array.length; i++) {
            if (start == i || array[start] != array[i]) {
                swap(array, start, i);
                Permutation(array, start + 1);
                swap(array, i, start);
            }

        }
    }
}
