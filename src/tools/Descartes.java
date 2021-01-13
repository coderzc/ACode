package tools;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaocong
 * Created on 2021-01-13
 */
public class Descartes {
    // 生成笛卡尔积
    //    1 3 5
    //    1 3 6
    //    1 4 5
    //    1 4 6
    //    ...

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 2}, {3, 4, 5}, {6, 7}, {8, 9, 10}};
        List<List<Integer>> lists = unionFun(arr);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println("");
        }
        unionFun(arr);
    }

    public static List<List<Integer>> unionFun(int[][] arr) {
        int totalCnt = 1;
        for (int i = 0; i < arr.length; i++) {
            totalCnt *= arr[i].length;
        }
        List<List<Integer>> result = new ArrayList<>();
        unionFun(arr, 0, 0, new ArrayList<>(), result, totalCnt);
        return result;
    }

    public static void unionFun(int[][] arr, int i, int j, List<Integer> list, List<List<Integer>> result,
            int totalCnt) {
        if (result.size() == totalCnt || i > arr.length - 1) {
            return;
        }

        // 向右移动
        if (j + 1 <= arr[i].length - 1) {
            List<Integer> listCopy = new ArrayList<>(list); // 向右移动时传入list副本
            unionFun(arr, i, j + 1, listCopy, result, totalCnt);
        }

        // 向下移动
        // 每次扫到第一行时重新初始化新的list
        if (i == 0) {
            list = new ArrayList<>();
        }
        list.add(arr[i][j]);
        unionFun(arr, i + 1, 0, list, result, totalCnt);

        // 当扫描到最后一行时把当前list加入到结果集中
        if (i == arr.length - 1) {
            result.add(list);
        }
    }
}
