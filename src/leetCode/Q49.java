package leetCode;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class Q49 {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q49 q49 = new Q49();
        List<List<String>> lists = q49.groupAnagrams(strings);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> old_list = map.get(s);
            if (old_list == null) {
                ArrayList<String> new_list = new ArrayList<>();
                new_list.add(str);
                map.put(s, new_list);
            } else {
                old_list.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
