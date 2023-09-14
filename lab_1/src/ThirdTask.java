import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args){
        int x = 0;
        int y = 0;
        int k = 0;
        boolean flag = true;
        System.out.println("Введите координаты клада ");
        Scanner in = new Scanner (System.in);
        int treasure_x = in.nextInt();
        int treasure_y = in.nextInt();
        String instruction = "";
        while(!instruction.equals("стоп")){
            instruction = in.nextLine();
                if (x==treasure_x && y==treasure_y) {
                    flag = false;
                }
            switch (instruction) {
                case ("север") -> {
                    y += in.nextInt();
                    if (flag) {
                        k++;
                    }
                }
                case ("юг") -> {
                    y -= in.nextInt();
                    if (flag) {
                        k++;
                    }
                }
                case ("восток") -> {
                    x += in.nextInt();
                    if (flag) {
                        k++;
                    }
                }
                case ("запад") -> {
                    x -= in.nextInt();
                    if (flag) {
                        k++;
                    }
                }
            }

        }
        System.out.println(k);
    }
}
