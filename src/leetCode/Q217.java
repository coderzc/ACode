package leetCode;

import java.util.HashSet;

/**
 * 217. 存在重复元素
 */
public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> keys = new HashSet<>();
        for (int num : nums) {
            if (keys.contains(num)) return true;
            keys.add(num);
        }

        return false;
    }
}
