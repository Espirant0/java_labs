import java.util.Scanner;

public class SixTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println("Введите элементы массива: ");
        int[][] array = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
                sum+=array[i][j];
            }
        }
        System.out.println("Сумма: " + sum);
    }
}

