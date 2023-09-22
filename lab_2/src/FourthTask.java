import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println("Введите элементы массива: ");
        int[][] array = new int[m][n];
        int[][] rotated_array = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                rotated_array[j][i] = array[m - i - 1][j];

        for (int[] row : rotated_array) {
                for (int el : row)
                    System.out.print(" " + el);
                System.out.println();
        }
    }
}
