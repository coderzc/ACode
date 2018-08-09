package tools;

public class Num {

    //计算位数
    public static int digit(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

}
