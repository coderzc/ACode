package leetCode;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 */
public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int fre[] = new int[256];
        int l = 0;
        int r = -1;
        int ret = 0;
        while (l < chars.length) {
            if (r + 1 < chars.length && fre[chars[r + 1]] == 0) {
                fre[chars[++r]]++;
            } else {
                fre[chars[l]]--;
                l++;
            }

            ret = Math.max(ret, (r - l + 1));
        }

        return ret;

    }


    public static void main(String[] args) {

    }
}
