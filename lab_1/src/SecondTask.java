import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        System.out.println("Введите n ");
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        if(n>0) {
            int[] array;
            array = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    array[i] = in.nextInt();
                } else {
                    array[i] = (-1) * in.nextInt();
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += array[i];
            }
            System.out.println(sum);
        } else {
            System.out.println("Число должно быть больше нуля!");
        }
    }
}
