package niukeBAT.strings;
/**
 * 反转句子
 */
public class ReversedSentence {
    public static void main(String[] args) {
        String a = "this is a dog";
        System.out.println(reversed(a));
    }

    private static String reversed(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String sReversedAll = stringBuilder.reverse().toString();
        String[] strings = sReversedAll.split(" ");
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            stringBuilder.setLength(0);
            stringBuilder.append(string);
            result.append(stringBuilder.reverse()).append(" ");
        }

        return result.toString();
    }

}
