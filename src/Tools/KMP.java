package Tools;

/**
 * str是否包含reg
 */
public class KMP {
    public static void main(String[] args) {
        String str = "ababccd";
        String reg = "abc";
        int isPattern = kmp(str, reg);
        System.out.println(isPattern);

    }

    //next数组表示匹配失败时模式字符串指针下一步要移动到的位置
    // ******next[j]=前(j-1)字串的最长前、后缀匹配长度 ........这里我也没弄懂要数学证明，先记下来********
    private static int[] getNext(String pString) {

        char[] p = pString.toCharArray();

        int[] next = new int[p.length];

        int k = -1;//k -> next[]每一位的值

        int j = 0;//模式字符串临时指针

        next[0] = -1;//第0位特殊位置(模式字符串不变，文本字符串向后)

        while (j + 1 < p.length) {//注意下标 每次我们求的是next[j+1]  所以j到不了最后一位

            if (k==-1||p[j] == p[k]) { //即p[j]==p[ next[j] ]
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


    public static int kmp(String tString, String pString) {
        char[] t = tString.toCharArray();
        char[] p = pString.toCharArray();

        int i=0;
        int j=0;

        int[] next=getNext(pString);

        while (i<t.length&&j<p.length){
            if(j==-1||t[i]==p[j]){ // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            }else {
                j=next[j];
            }
        }

        if(j==p.length){
            return i-j;
        }else {
            return -1;
        }

    }

}
