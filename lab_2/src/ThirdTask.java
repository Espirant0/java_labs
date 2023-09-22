public class ThirdTask {
    public static void main(String[] args) {
        int [] array = {1, -2, 5, 3 , -3, 4, 9};
        System.out.println("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        int max_sum = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                max_sum = Math.max(max_sum, sum);
            }
        }
        System.out.println("\nМаксимальная сумма подмассива = " + max_sum);
    }
}
