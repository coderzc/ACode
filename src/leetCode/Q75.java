package leetCode;

/**
 * 颜色分类
 */
public class Q75 {

    //交换数组中两个位置的元素
    private void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * 计数排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int bucket[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {//i表示第几个桶
            for (int j = 0; j < bucket[i]; j++) {//j表示每个桶出桶扫描
                nums[index++] = i;
            }
        }
    }

    /**
     * 仿三路快排思想
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;

        int zero = -1; //[0...zero] == 0
        int two = n;   //[two...n-1] == 0

        for (int i = 0; i < two; ) {// zero<i<two
            if (nums[i] == 1) i++;
            else if (nums[i] == 2) swap(nums, --two, i);
            else {
                swap(nums, ++zero, i);
                i++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        Q75 q75 = new Q75();
        q75.sortColors2(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
