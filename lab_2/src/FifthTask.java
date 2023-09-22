public class FifthTask {
    public static void main(String[] args) {
        int [] array = {1, 2, 4, 23, 5, 92};
        int target = 94;
        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nСумма: " + target);
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println("Пара чисел: " + array[i] + " " + array[j]);
                    return;
                }
            }
        }
        System.out.println("null");
    }
}
