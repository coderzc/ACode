/**
 * 斐波那契非递归
 */
public class Question9 {
    public static long fib(int n) {
        if (n<0) return -1;//输入非法
        if(n==0) return 0;
        if(n==1) return 1;

        long f0 = 0;
        long f1 = 1;

        for(int i=2;i<=n;i+=2){//从偶数位开始
            f0=f0+f1;//偶数位
            f1=f0+f1;//奇数位
        }
        if(n%2==0){
            return f0;
        }else {
            return f1;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
