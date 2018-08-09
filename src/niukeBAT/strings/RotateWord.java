package niukeBAT.strings;

import tools.KMP;

/**
 * 判断两个此是否互为旋转词
 * 旋转词：把一个字符串 任意前面 部分 挪到后面 1234-> 2341 3412 4123
 */
public class RotateWord {
    public static void main(String[] args) {
        System.out.println(isRotateWord("1234","4123"));
    }

    private static boolean isRotateWord(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String sum = s1 + s1;
        return KMP.kmp(sum, s2) >= 0;
    }
}
