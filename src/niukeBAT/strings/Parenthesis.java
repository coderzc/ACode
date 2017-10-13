package niukeBAT.strings;

/**
 * 小括号合法性检测
 */
public class Parenthesis {
    public static void main(String[] args) {
        System.out.println(chkParenthesis("(w)(s)(a)()"));
    }

    private static boolean chkParenthesis(String str) {
        int num = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (num < 0) {
                break;
            }
            if (c == '(') {
                num++;
            }
            if (c == ')') {
                num--;
            }
        }

        return num == 0;

    }
}
