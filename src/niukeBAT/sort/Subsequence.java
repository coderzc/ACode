package niukeBAT.sort;

/**
 * 最短乱序长度
 */
public class Subsequence {
    public static void main(String[] args) {
        int[] array = {1,5,6,3,2,6,6,7};
        System.out.println(shortSubsequence(array));
    }

    private static int shortSubsequence(int[] array) {
        int max = array[0];
        int min = array[array.length - 1];
        int r = 0;
        int l = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                l = i;
            }
        }

        System.out.println(r + "---" + l);

        return r - l + 1;
    }
}
