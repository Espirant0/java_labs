import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println("Введите n ");
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        if (n>0){
            int k = 0;
            while (n!=1) {
                if (n%2==0){
                    n = n/2;
                } else {
                    n = 3*n+1;
                }
                k++;
            }
            System.out.println("Количество шагов = " + k);
        } else {
            System.out.println("Число должно быть наутральным! ");
        }
    }
}
