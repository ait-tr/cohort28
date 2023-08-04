import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitsFreqAppl1 {

        static Random random = new Random();
        public static void main(String[] args) {
            //TODO Generate 1_000_000 random int positive numbers
            // and calculate digits frequency
            // 18374, 9832, 67, 3525  [1] -> 1, [2] -> 2, [0] -> [3] -> 3, ...
            // random.nextInt(Integer.MAX_VALUE);
            // подсчитать частоту встречаемости каждой цифры всех таких числах


            // шаг 1 выбрать ответ на вопрос - хранить эти случайные числа или нет?
            // ответ - хранить не надо

            // Что делать? - запустить цикл на 1 000 000 раз

            Map<String, Integer > digFreq = new HashMap<>();
            // Map - это такая структура, в которой хранятся пары значений (Ключ, Значение)
            // В нашем случае это будет (цифра, частоту или количество раз)

            int count0, count1, count2,count3, count4, count5, count6, count7,count8, count9;

            for (int i = 0; i < 10; i++) {
                // генерируем случайное число
                int r = random.nextInt(Integer.MAX_VALUE);
                // получилось, например, 10 239 876 - надо каждое такое случайное число разбить на цифры!!!
                // для этого, переводим это число в тип String
                String s = Integer.toString(r);
                // все эти числа-строки разделяем на цифры методом split
                String[] digits = s.split(""); // теперь в массиве digits лежат именно цифры
                // как подсчитать частоту каждой цифры 0, 1, ...,9 ?
                for (int j = 0; j < digits.length; j++) {


                }

            }
        }
}


//    Map<String, Integer> res = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//        if (res.containsKey(words[i])) {
//        res.put(words[i], res.get(words[i]) + 1);
//        } else {
//        res.put(words[i], 1);