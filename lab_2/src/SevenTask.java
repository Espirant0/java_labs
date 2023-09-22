import java.util.Scanner;

public class SevenTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println("Введите элементы массива: ");
        int[][] array = new int[m][n];
        int[] max_array = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] >= max) {
                    max = array[i][j];
                }
            }
            max_array[i] = max;
            max = 0;
        }
        for (int i = 0; i < m; i++){
            System.out.println("Максимум " + (i+1) + " строки = " + max_array[i]);
        }
    }
}
