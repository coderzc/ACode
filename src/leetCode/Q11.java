package leetCode;

/**
 * 盛最多水的容器
 */
public class Q11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            //计算容器容量
            int minHeight = Math.min(height[l], height[r]);
            if (max < (r - l) * minHeight) {
                max = (r - l) * minHeight;
            }

            //移动短板
            if (minHeight == height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
