import java.util.Scanner;

public class functions {
    public static void printCinema(Cinema cinema){
        System.out.println("Кинотеатр: " + cinema.getName());
        System.out.println();
    }
    public static void printSeance(Seance seance){
        System.out.println("Кинотеатр: " + seance.getCinema().getName());
        System.out.println("Фильм: " + seance.getTitle());
        System.out.println("Начало: " + seance.getStart() + ". Окончание: " + seance.getEnd());
        System.out.println("Зал №" + seance.getHall().getHallId());
        System.out.println("Схема зала:");
        printSeanceHall(seance.getHall());
        System.out.println();
    }

    public static void printSeanceHall(Hall hall){
        System.out.println("Свободные места: [ ]");
        hall.printSeats();
    }
    public static void buyTicket(Seance [] seances) {
        boolean is_correct = true;
        int row_num = 0;
        int place_num = 0;
        System.out.println("Введите номер сеанса");
        System.out.println();
        Scanner in = new Scanner(System.in);
        int seance_num = in.nextInt();
        if (seance_num > seances.length - 1 || seance_num < 0){
            is_correct = false;
            System.out.println("Вы ввели неверный сеанс");
        }
        else {
            System.out.println("Сеанс №" + (seance_num));
            printSeance(seances[seance_num-1]);
            System.out.println("Выберите ряд");
            row_num = in.nextInt();
            if (row_num > seances[seance_num - 1].getHall().getRow() || row_num - 1 < 0){
                is_correct = false;
                System.out.println("Вы ввели неверный ряд");
            }
            else {
                System.out.println("Выберите место");
                place_num = in.nextInt();
                if (place_num > seances[seance_num - 1].getHall().getSeat() || place_num - 1 < 0){
                    is_correct = false;
                    System.out.println("Вы ввели неверное место");
                }
            }
        }
        if (is_correct && !seances[seance_num-1].getHall().setSeat(row_num - 1, place_num - 1)){
            System.out.println("Покупка завершена");
            System.out.println("Кинотеатр: " + seances[seance_num-1].getCinema().getName());
            System.out.println("Фильм: " + seances[seance_num-1].getTitle());
            System.out.println("Начало сеанса: " + seances[seance_num-1].getStart());
            System.out.println("Зал №" + seances[seance_num-1].getHall().getHallId());
            System.out.println("Ваше место: " + row_num + " ряд, " + place_num + " место");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("Неправильный ввод данных. Повторите попытку");
            System.out.println();
        }
    }
}