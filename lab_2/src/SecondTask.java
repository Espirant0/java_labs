public class SecondTask {
    public static void main(String[] args) {
        int [] array1 = {3, 2, 8, 15, 5};
        int [] array2 = {4, 1, 73, 24, 7};
        System.out.println("Массив 1: ");
        for (int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        System.out.println("\nМассив 2: ");
        for (int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }
        for (int i = 0; i < array1.length - 1; i++) {
            for(int j = 0; j < array1.length - i - 1; j++) {
                if(array1[j + 1] < array1[j]) {
                    int swap = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < array2.length - 1; i++) {
            for(int j = 0; j < array2.length - i - 1; j++) {
                if(array2[j + 1] < array2[j]) {
                    int swap = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = swap;
                }
            }
        }
        int [] result = new int [array1.length+array2.length];
        int pos1=0, pos2=0;
        for (int k=0; k<result.length; k++) {
            if (pos1 > array1.length-1) {
                int a = array2[pos2];
                result[k] = a;
                pos2++;
            }
            else if (pos2 > array2.length-1) {
                int a = array1[pos1];
                result[k] = a;
                pos1++;
            }
            else if (array1[pos1] < array2[pos2]) {
                int a = array1[pos1];
                result[k] = a;
                pos1++;
            }
            else {
                int b = array2[pos2];
                result[k] = b;
                pos2++;
            }
        }
        System.out.println("\nИтоговый массив: ");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
