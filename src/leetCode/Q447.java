package leetCode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 447. 回旋镖的数量
 */
public class Q447 {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        Q447 q447 = new Q447();
        int i = q447.numberOfBoomerangs(points);
        System.out.println(i);
    }

    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);  //返回(x1-x2)^2+(y1-y2)^2
    }

    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> record = new HashMap<>(); //<所有点到i点的距离，出现的频率>
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int dis = dis(points[i], points[j]);
                    Integer fre = record.get(dis);
                    if (fre == null) {
                        record.put(dis, 1);
                    } else {
                        record.put(dis, fre + 1);
                    }
//                    record.compute(dis,(k,v)->v==null?1:v+1);  Java8 写法2 性能有损失
//                    record.merge(dis,1,(a,b)->a+b);            java8 写法3 性能有损失
                }
            }

            for (int fre : record.values())
                if (fre >= 2)
                    ret += fre * (fre - 1);
        }


        return ret;

    }
}
