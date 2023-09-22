import java.util.HashSet;
import java.util.Set;

public class FirstTask {
    public static void main(String[] args) {
        String s = "abcdabgsdadde";
        System.out.println("Исходная строка: " + s);
        Set<Character> unique_array = new HashSet<>(); //Множество для хранения уникальных символов
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<s.length() && j<s.length()){
            if (!unique_array.contains(s.charAt(j))){ //Если символ не встречался ранее, добавляем в массив
                unique_array.add(s.charAt(j++));
                count = Math.max(count, j - i);
            } else {
                unique_array.remove(s.charAt(i++));
            }
        }
        System.out.println("Длина уникальной строки: " + count);
    }
}