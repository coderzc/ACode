package leetCode;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 */
public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int l = 0;
        int r = 0;
        TreeSet<Long> keys = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (keys.ceiling((long) nums[i] - t) != null && keys.ceiling((long) nums[i] - t) <= (long) nums[i] + t)
                return true;

            keys.add((long) nums[i]);

            if (keys.size() == k + 1) {
                keys.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
