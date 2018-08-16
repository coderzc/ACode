package leetCode;

/**
 * 删除排序数组中的重复项
 */
public class Q26 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Q26 q26 = new Q26();
        int i1 = q26.removeDuplicates(arr);

        for (int i = 0; i < i1; i++) {
            System.out.println(arr[i]);
        }
    }
}
