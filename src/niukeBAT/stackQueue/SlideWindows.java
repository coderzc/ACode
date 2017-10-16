package niukeBAT.stackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 滑动窗口求每次窗口最大值
 */
public class SlideWindows {
    public static void main(String[] args) {
        int[] array = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(getMax(array,3)));
    }

    /**
     *
     * @param array
     * @param w 窗口大小
     * @return
     */
    private static int[] getMax(int[] array, int w) {
        Deque<Integer> qmax = new ArrayDeque<>();//双端队列 下标
        int[] maxArray = new int[array.length - w + 1];

        for (int i = 0; i < array.length; i++) {
            while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]) {
                qmax.pollLast();
            }
            qmax.offerLast(i);

            if (i >= w - 1) {
                if (qmax.peekFirst() < i - w + 1) {//队头已经过期
                    qmax.pollFirst();
                }
                maxArray[i - w + 1] = array[qmax.peekFirst()];
            }
        }

        return maxArray;
    }
}
