package niukeBAT.sort;
/**
 * 三色旗排序
 */

import java.util.Arrays;

public class ThreeColor {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 1, 2, 0, 1, 0, 1, 2, 2, 1};
        sortThreeColor(array);
        System.out.println(Arrays.toString(array));
    }

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void sortThreeColor(int[] array) {
        int l = 0;
        int r = array.length - 1;
        for (int i = 0; i <= r && i < array.length; i++) {
            if (array[i] == 0) {
                swap(array, i, l);
                l++;
            }
            if (array[i] == 2) {
                swap(array,i,r);
                r--;
                i--;
            }

        }
    }
}
