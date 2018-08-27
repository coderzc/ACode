package leetCode;

/**
 * 345. 反转字符串中的元音字母
 */
public class Q345 {
    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();

        while (true) {
            while (l < s.length() && !isVowels(chars[l])) {
                l++;
            }
            while (r >= 0 && !isVowels(chars[r])) {
                r--;
            }

            if (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;

                l++;
                r--;
            } else {
                break;
            }
        }

        return new String(chars);
    }
}
