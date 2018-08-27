package leetCode;

/**
 * 76. 最小覆盖子串
 */
public class Q76 {
    public static void main(String[] args) {
        Q76 q76 = new Q76();

        String s = "ab";
        String t = "a";
        String s1 = q76.minWindow(s, t);
        System.out.println(s1);


    }

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        int l = 0;
        int r = 0;
        String ret = "";
        int minLength = s.length() + 1;
        int count = t.length();
        int[] fre = new int[256];

        for (int i = 0; i < t.length(); i++) {
            fre[t.charAt(i)]++;
        }

        while (r < s.length()) {
            while (count > 0 && r < s.length()) {
                if (fre[s.charAt(r++)]-- > 0) {
                    count--;
                }
            }
            while (count == 0 && l < s.length()) {
                if (fre[s.charAt(l++)]++ >= 0) {
                    count++;
                }
            }

            if ((r - l + 1) < minLength && l >= 1) {
                ret = s.substring(l - 1, r);
                minLength = (r - l + 1);
            }

        }

        return ret;

    }
}
