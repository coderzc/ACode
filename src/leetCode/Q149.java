package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 */
public class Q149 {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        int maxCount = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Map<Integer, Integer>, Integer> record = new HashMap<>();
            int originCount = 0;//与i相同点的个数
            for (int j = 0; j < points.length; j++) {

                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        originCount++;
                    } else {
                        Map<Integer, Integer> dir = dir(points[i], points[j]);
                        record.put(dir, record.getOrDefault(dir, 0) + 1);
                    }
            }

            if (record.size() == 0) {
                maxCount = Math.max(maxCount, originCount);
            } else {
                for (Integer fre : record.values()) {
                    maxCount = Math.max(maxCount, fre + originCount);
                }
            }
        }

        return maxCount; //没有连线，那么最小也是1个单点
    }

    private Map<Integer, Integer> dir(Point origin, Point point) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dx = (origin.x - point.x);
        int dy = (origin.y - point.y);
        int d = gcd(dx, dy);
        map.put(dx / d, dy / d);
        return map;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(94911151, 94911150);
        Point point3 = new Point(94911152, 94911151);
//        Point point4 = new Point(4, 1);
//        Point point5 = new Point(2, 3);
//        Point point6 = new Point(1, 4);
//        Point[] points = {point1, point2, point3};
//
        Q149 q149 = new Q149();
//        int i = q149.maxPoints(points);
//        System.out.println(i);

    }
}
