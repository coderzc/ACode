package leetCode;

/**
 * 寻找数组中第k大元素
 */
public class Q215 {

    //交换数组中两个位置的元素
    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length < k) return -1;

        int l = 0;
        int r = nums.length - 1;
        while (l - r + 1 <= k) {
            int p = nums[l];
            int i = l + 1;
            int j = r;
            while (true) {
                while (i <= r && nums[i] > p) i++;
                while (j >= l + 1 && nums[j] < p) j--;

                if (i >= j) break;
                else swap(nums, i++, j--);
            }
            swap(nums, j, l);

            if (k == j + 1) return p;
            else if (k < j + 1) {
                r = j - 1;
            } else {
                l = j + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {2, 1};
        Q215 q215 = new Q215();
        int kthLargest = q215.findKthLargest(arr, 2);
        System.out.println(kthLargest);
    }
}
