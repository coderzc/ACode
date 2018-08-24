package exam;

public class FindString {
    public static int findString(String[] str, String target) {
        int l = 0;
        int r = str.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (str[mid].trim().isEmpty()) {
                while (str[mid].trim().isEmpty()) {
                    mid--;
                }
            }

            if (str[mid].equals(target)) return mid;

            if (str[mid].compareTo(target) > 0) {
                r = mid - 1;
            }

            if (str[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String[] array = {"a", "b", "", "c", "", "d"};
        int c = findString(array, "c");
        System.out.println(c);
    }
}
