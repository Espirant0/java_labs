import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Система кинотеатров v1.0");
        Hall[] halls = new Hall[3];
        Hall hall1 = new Hall(1,10, 15);
        Hall hall2 = new Hall(2,5, 8);
        Hall hall3 = new Hall(1,4, 4);
        halls[0] = hall1;
        halls[1] = hall2;
        halls[2] = hall3;

        Cinema[] cinemas = new Cinema[3];
        Cinema Karo = new Cinema("Каро фильм", halls);
        Cinema SilverCinema = new Cinema("Сильвер Синема", halls);
        Cinema CinemaPark = new Cinema("Синема Парк", halls);
        cinemas[0] = Karo;
        cinemas[1] = SilverCinema;
        cinemas[2] = CinemaPark;

        Seance[] seances = new Seance[3];
        Seance seance1 = new Seance(cinemas[0], "Аватар", cinemas[0].getHalls()[0], "10:00", "12:00");
        Seance seance2 = new Seance(cinemas[1], "Терминатор", cinemas[1].getHalls()[1], "11:00", "13:00");
        Seance seance3 = new Seance(cinemas[1], "Форсаж 14", cinemas[2].getHalls()[2], "21:00", "23:00");
        seances[0] = seance1;
        seances[1] = seance2;
        seances[2] = seance3;

        while(true){
            System.out.println("Список команд:");
            System.out.println("1 - Посмотреть список сеансов");
            System.out.println("2 - Посмотреть список кинотеатров");
            System.out.println("3 - Купить билет");
            System.out.println("4 - Выход");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            switch (input) {
                case (1) -> {
                    System.out.println("Доступные сеансы");
                    for(int i = 0; i < seances.length; i++) {
                        System.out.println("Сеанс №" + (i+1));
                        functions.printSeance(seances[i]);
                    }
                }
                case(2) -> {
                    for(int i = 0; i < seances.length; i++)
                        functions.printCinema(cinemas[i]);
                }
                case (3) -> {
                    functions.buyTicket(seances);
                }
                case (4) -> {
                    in.close();
                    return;
                }
                default -> System.out.println("Неверная команда!");
            }
        }
    }
}