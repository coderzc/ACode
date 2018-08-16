package leetCode;

/**
 * 移除元素
 */
public class Q27 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        Q27 q27 = new Q27();
        int i1 = q27.removeElement(arr, 3);

        for (int i = 0; i < i1; i++) {
            System.out.println(arr[i]);
        }
    }
}
