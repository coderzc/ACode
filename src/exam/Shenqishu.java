package exam;
/**
 * 一个数是否可以 拿出其中几个位上数之和等于其余位数之和 则成为神奇数
 */

import java.util.Scanner;

public class Shenqishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(isShenqishu(num));

    }

    public static boolean isShenqishu(int num) {
        int sum = 0;
        int tmp = num;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        if ((sum & 1) == 1) {//奇数一定不是
            return false;
        }

        boolean[] dp = new boolean[sum + 1];//流动数组记录每位与后几位能不能加出0～sum
        dp[0] = true;
        int cur = 0;//每一位数
        while (tmp != 0) {
            cur = tmp % 10;
            for (int i = sum; i >= 1; i--) {
                if (dp[i] == false && i - cur >= 0 && dp[i - cur] == true) {
                    dp[i] = true;
                }
                if (i == sum / 2 && dp[i] == true) return true;
            }

            tmp = tmp / 10;
        }
        return false;
    }
}
