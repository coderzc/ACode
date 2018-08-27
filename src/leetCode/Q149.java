package leetCode;

import java.util.HashMap;

/**
 * 149. 直线上最多的点数
 */
public class Q149 {

    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 2);
        Point point3 = new Point(5, 3);
        Point point4 = new Point(4, 1);
        Point point5 = new Point(2, 3);
        Point point6 = new Point(1, 4);
        Point[] points = {point1, point2, point3, point4, point5, point6};

        Q149 q149 = new Q149();
        int i = q149.maxPoints(points);
        System.out.println(i);
    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        int maxCount = 1;  //没有连线，那么最小也是1个单点
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> record = new HashMap<>();
            int originCount = 0;//与i相同点的个数
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        originCount++;
                    } else {
                        double dir = dir(points[i], points[j]);
                        Integer fre = record.get(dir);
                        if (fre == null) {
                            record.put(dir, 2);
                        } else {
                            record.put(dir, fre + 1);
                        }
                    }
                }
            }


            for (Integer fre : record.values()) {
                maxCount = Math.max(maxCount, fre + originCount);
            }
        }

        return maxCount;
    }

    private double dir(Point origin, Point point) {
        if (origin.y == point.y) return 0.0;
        return (origin.x - point.x) / (origin.y - point.y);
    }

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
}
