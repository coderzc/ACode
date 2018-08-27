package leetCode;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 */
public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer integer = record.get(s.charAt(i));
            if (integer == null) {
                record.put(s.charAt(i), 1);
            } else {
                record.put(s.charAt(i), integer + 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            Integer integer = record.get(t.charAt(j));
            if (integer == null) return false;
            else {
                record.put(t.charAt(j), --integer);
                if (integer == 0) record.remove(t.charAt(j));
            }
        }


        return record.size() == 0;
    }
}
