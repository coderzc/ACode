package leetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 */
public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 0;
        HashSet<Integer> keys = new HashSet<>();
        while (r < nums.length) {

            if (keys.contains(nums[r]))
                return true;

            keys.add(nums[r++]);

            if (keys.size() == k + 1 && l < nums.length)
                keys.remove(nums[l++]);

        }

        return false;
    }
}
