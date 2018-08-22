package leetCode;

/**
 * 和 >=S 长度最小的子数组
 */
public class Q209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        //nums[l...r]为滑动窗口
        int l = 0;
        int r = -1;
        int sum = 0;
        int ret = nums.length + 1;//连续子数组长度，初始化为一个不可能取到的值

        while (l < nums.length) {

            if (sum < s && r < nums.length - 1) {
                r++;
                sum += nums[r];
            } else if (sum >= s && l <= r) {
                sum -= nums[l];
                l++;
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
}
