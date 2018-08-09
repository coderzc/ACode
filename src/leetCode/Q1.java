package leetCode;

/**
 * 两数之和 Two Sum
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q1 {

    /**
     * 我的代码
     */
    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        return ret;
    }

    /**
     * 最优算法
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                res[0] = map.get(target - numbers[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 10};
        int target = 9;

        Q1 q1 = new Q1();
        int[] ints = q1.twoSum2(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}
