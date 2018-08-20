package leetCode;

/**
 * 验证回文串
 */
public class Q125 {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-z^A-Z^0-9]", "").toLowerCase();
        char[] chars = s1.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
