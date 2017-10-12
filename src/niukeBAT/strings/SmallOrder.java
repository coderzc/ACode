package niukeBAT.strings;

import java.util.Arrays;

/**
 * 拼接最小字典序
 */
public class SmallOrder {
    public static void main(String[] args) {
        String[] strs={"ed","abc"};
        System.out.println(findSmallOrder(strs));
    }

    private static String findSmallOrder(String[] strs) {
        quickSort(strs);
        StringBuilder stringBuilder = new StringBuilder();
        for (String x : strs) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }

    private static boolean compareXiaoyu(String s1, String s2) {//这是这道题的重点
        String s3 = s1 + s2;
        String s4 = s2 + s1;
        return s3.compareTo(s4) < 0;
    }

    private static void quickSort(String[] strs) {
        quickSort2(strs, 0, strs.length - 1);
    }

    //交换数组中两个位置的元素
    private static void swap(String arr[], int x, int y) {
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //双路快排
    private static void quickSort2(String[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        swap(array, l, ((int) (Math.random() * (r - l)) + l));
        String pivote = array[l];//基点放到最左边

        int i = l + 1;//左边比基点小的指针
        int j = r;//右边比基点大的指针
        while (true) {
            while (i <= r && compareXiaoyu(array[i], pivote)) {
                i++;
            }
            while (j >= l + 1 && compareXiaoyu(pivote, array[j])) {
                j--;
            }

            if (i > j)  break;
            else  swap(array, i++, j--);
        }

        swap(array, j, l);

        quickSort2(array, l, j - 1);
        quickSort2(array, j + 1, r);
    }
}
