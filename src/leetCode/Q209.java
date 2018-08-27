package leetCode;

/**
 * 和 >=S 长度最小的子数组  滑动窗口
 */
public class Q209 {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1};
        Q209 q209 = new Q209();
        int i = q209.minSubArrayLen2(7, array);
        System.out.println(i);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        //nums[l...r]为滑动窗口
        int l = 0;
        int r = -1;
        int sum = 0;
        int ret = nums.length + 1;//连续子数组长度，初始化为一个不可能取到的值

        while (l < nums.length) {

            if (sum < s && r < nums.length - 1) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                ret = Math.min(ret, r - l + 1);
            }

        }

        if (ret == nums.length + 1) {
            return 0;
        } else {
            return ret;
        }
    }

    public int minSubArrayLen2(int s, int[] nums) {
        if (nums.length == 0) return 0;
        //nums[l...r) sum>=s
        int l = 0;
        int r = 0;
        int sum = 0;
        int ret = nums.length + 1;//连续子数组长度，初始化为一个不可能取到的值

        while (r < nums.length) {

            while (sum < s && r < nums.length) {
                sum += nums[r++];
            }

            while (sum >= s && l < r) {
                sum -= nums[l++];
            }

            ret = Math.min(ret, r - l + 1);
        }

        return ret == nums.length + 1 ? 0 : ret;
    }
}
