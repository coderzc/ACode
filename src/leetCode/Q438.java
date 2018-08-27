package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词  滑动窗口
 *
 */
public class Q438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        Q438 q438 = new Q438();
        List<Integer> anagrams = q438.findAnagrams(s, p);
        anagrams.forEach(System.out::println);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

        int[] fre = new int[256];// 小于0表示[l~r)中的非p元素，大于零表示还有元素没在[l~r)中
        int l = 0;
        int r = 0;
        int count = p.length();//p剩余字符的个数

        for (char c : p.toCharArray()) {
            fre[c]++;
        }

        while (r < s.length()) {

            if (fre[s.charAt(r++)]-- > 0) {
                count--;
            }
            if (count == 0) result.add(l);
            if (r - l == p.length() && fre[s.charAt(l++)]++ >= 0) {
                count++;
            }

        }

        return result;
    }
}
