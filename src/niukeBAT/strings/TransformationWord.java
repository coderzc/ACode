package niukeBAT.strings;

import java.util.HashMap;
import java.util.Map;

public class TransformationWord {
    public static void main(String[] args) {
        System.out.println(isTransformationWord("abc", "bca"));
        System.out.println(isTransformationWord("abc","bda"));
    }

    private static boolean isTransformationWord(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map1.merge(c, 1, (a, b) -> a + b);//java8
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.merge(c, 1, (a, b) -> a + b);
        }

        return map1.equals(map2);
    }

}
