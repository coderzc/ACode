package leetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 */
public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }


        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) map.remove(nums2[i]);
            }
        }

        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        Q350 q350 = new Q350();
        q350.intersect(num1, num2);
    }
}
