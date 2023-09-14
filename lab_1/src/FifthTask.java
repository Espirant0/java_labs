import java.util.Scanner;

public class FifthTask{
        public static void main(String[] args) {
            System.out.println("Введите число ");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            if(n/100>=1 && n/100<=9) {
                int d1, d2, d3;
                d1 = n % 10;
                d2 = n / 10 % 10;
                d3 = n / 100 % 10;
                int sum = d1 + d2 + d3;
                int mul = d1 * d2 * d3;
                if (mul % 2 == 0 && sum % 2 == 0) {
                    System.out.println("Число дважды чётное");
                } else {
                    System.out.println("Число не является дважды чётным");
                }
            } else {
                System.out.println("Число должно быть трёхзначным! ");
            }
        }
}
