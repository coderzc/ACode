package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Move Zeroes
 */
public class Q283 {
    //交换数组中两个位置的元素
    private void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * 时间 O(n)
     * 空间 O(n)
     */
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                list.add(nums[i]);

        for (int i = 0; i < list.size(); i++)
            nums[i] = list.get(i);

        for (int i = list.size(); i < nums.length; i++)
            nums[i] = 0;
    }


    /**
     * 时间 O(n)
     * 空间 O(1)
     */
    public void moveZeroes2(int[] nums) {
        //非零元素的存放索引 [0...k) 都是非零
        int k = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 时间 O(n)
     * 空间 O(1)
     */
    public void moveZeroes3(int[] nums) {
        //非零元素的存放索引 [0...k) 都是非零
        int k = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                if (i != k) swap(nums, k, i);
                k++;
            }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        Q283 q283 = new Q283();
        q283.moveZeroes3(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
