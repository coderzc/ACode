package exam;

/**
 * a[i]-a[j] 最大值
 * i>j
 */
public class findMaxCha {

    private static int findMaxCha(int[] a) {
        if (a == null || a.length < 2) return -1;
        int min = Math.min(a[0], a[1]);
        int maxCha = a[1] - a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] - min > maxCha) {
                maxCha = a[i] - min;
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        return maxCha;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 1};
        System.out.println(findMaxCha(array));
    }

}
