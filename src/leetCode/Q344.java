package leetCode;

import java.util.Arrays;

/**
 * 反转字符串
 */
public class Q344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Q344 q344 = new Q344();
        String asdfghjkl = q344.reverseString("asdfghjkl");
        System.out.println(asdfghjkl);

//        String s="sdafsadf";
//        StringBuilder stringBuilder=new StringBuilder(s);
//        stringBuilder.reverse();
    }
}
