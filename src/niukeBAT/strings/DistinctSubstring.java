package niukeBAT.strings;
/**
 * 求最长无重复子串
 */

import java.util.HashMap;
import java.util.Map;

public class DistinctSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aabac"));
    }

    private static int longestSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();//每个字符最后一次出现的位置
        int start = 0;//每一位的最长无重复子串的起始位置
        int max_length = 0;//目前为止(最长无重复子串长度)的最大值

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) != null && start < i + 1) {
                start = map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);
            max_length = Math.max(max_length, i - start + 1);
        }

        return max_length;
    }
}
