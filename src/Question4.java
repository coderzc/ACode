/**
 * 替换字符串的空格(在原来的字符串上替换)
 *
 */
public class Question4 {
    public static void main(String[] args) {
        String str = "we are happy .";

        int blank_count = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ch == ' ') {
                blank_count++;
            }
        }

        int p1 = str.length() - 1;
        int p2 = str.length() - 1 + 2 * blank_count;

        //TODO 不适合java


    }
}
