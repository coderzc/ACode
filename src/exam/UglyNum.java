package exam;
/**
 * 寻找第n个丑数
 */

import java.util.Scanner;

public class UglyNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int arr[] = new int[n];
        arr[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(Math.min(2 * arr[p1], 3 * arr[p2]), 5 * arr[p3]);
            if (arr[i] == 2 * arr[p1]) {
                p1++;
            }
            if (arr[i] == 3 * arr[p2]) {
                p2++;
            }
            if (arr[i] == 5 * arr[p3]) {
                p3++;
            }

        }
        System.out.println(arr[n - 1]);

        scanner.close();

    }

}
