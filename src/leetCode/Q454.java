package leetCode;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 */
public class Q454 {
    public static void main(String[] args) {
        Q454 q454 = new Q454();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int i = q454.fourSumCount(A, B, C, D);
        System.out.println(i);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ret = 0;
        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer integer = record.get(C[i] + D[j]);
                if (integer == null) {
                    record.put(C[i] + D[j], 1);
                } else {
                    record.put(C[i] + D[j], integer + 1);
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (record.containsKey(0 - (A[i] + B[j]))) {
                    ret = ret + record.get(0 - (A[i] + B[j]));
                }
            }
        }

        return ret;
    }
}
