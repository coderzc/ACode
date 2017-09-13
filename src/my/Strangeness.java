package my;

import java.util.Scanner;

/**
 * 奇异数 求L-R中奇异数个数
 */
public class Strangeness {
    //计算位数
    private static int digit(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

private static boolean jiyi(int num){
        int temp=0;
        num/=10;
        temp=num;
        num/=10;
        if(temp==num){
            return true;
        }else {
            return false;
        }
        //TODO
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.close();
    }
}
