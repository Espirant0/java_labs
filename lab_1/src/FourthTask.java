import java.util.Scanner;

public class FourthTask {
    public static void main(String[] args){
        int max_height = 0;
        int road_num = 0;
        Scanner logisticScan = new Scanner(System.in);
        int roads;
        System.out.println("Введите количество дорог: ");
        roads = logisticScan.nextInt();
        for(int i = 0; i < roads; i++) {
            int max = 9999999;
            int tunnel_count;
            System.out.println("Введите количество туннелей: ");
            tunnel_count = logisticScan.nextInt();
            System.out.println("Введите высоту туннелей: ");
            for (int j = 0; j < tunnel_count; j++) {
                int tunnel_height;
                tunnel_height = logisticScan.nextInt();
                if(max > tunnel_height)
                    max = tunnel_height;
            }
            if(max_height < max) {
                max_height = max;
                road_num++;
            }
        }

        System.out.println("Номер дороги: " + road_num);
        System.out.println("Минимальная высота машины: " + max_height);
    }
}
