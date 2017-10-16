package exam;
/**
 *  二分查找 (相同元素取最大下标)
 */
public class BinarySearchMax {
    public static void main(String[] args) {
        int a[] = {2,3};
        int bsm = bsm(a, 2);
        System.out.println(bsm);

    }

    private static int bsm(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (array[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (array[r] == k) {
            return r;
        }
        else if (r - 1 >= 0 && array[r - 1] == k) {
            return r - 1;
        }
        else {
            return -1;
        }
    }
}
