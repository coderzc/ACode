package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * TODO 不会
 */
public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List result = new ArrayList();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;

        int[] fre = new int[256];
        int l = 0;
        int r = 0;
        int count = p.length();

        for (char c : p.toCharArray()) {
            fre[c]++;
        }

        while (r < s.length()) {
            if (fre[s.charAt(r)] > 0) {
                fre[s.charAt(r)]--;
                r++;
                count--;
            }
            if (count == 0) result.add(l);
            if (fre[s.charAt(r)] == 0) {
                fre[s.charAt(l)]++;
                l++;
                count++;
            }
        }

        return result;
    }
}
