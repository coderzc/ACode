/**
 * 有序二维数组，二分查询
 */
public class Question3 {
    private static Boolean find(int[][] matrix, int number) {
        boolean found = false;
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int i = 0;//比较点所在行号
            int j = matrix[0].length - 1;//比较点所在列号
            while (i <= matrix.length && j >= 0) {
                if (matrix[i][j] == number) {
                    found = true;
                    break;
                } else if (matrix[i][j] > number) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(matrix, 7));
    }
}
