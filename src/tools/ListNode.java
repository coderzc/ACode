package tools;

import java.util.Scanner;

/**
 * @author zhaocong
 * Created on 2020-11-24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int[][] ma = new int[a][b];
        a = 100;
        System.out.println(ma);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
