package leetCode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 349. 两个数组的交集
 */
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] ret = new int[set2.size()];

        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            ret[i] = iterator.next();
            i++;
        }

        return ret;

    }
}

