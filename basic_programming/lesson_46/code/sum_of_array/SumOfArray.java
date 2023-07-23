package sum_of_array;

public class SumOfArray {
    public static void main(String[] args) {

        int[] arr = new int[100]; // 100 элементов, индексы о 0 до 99

        int sum1 = 0;

        // заполнение массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " | ");
            sum1 += arr[i];
        }

        System.out.println();
        System.out.println("Сумма рассчитанная в цикле : " + sum1);
        int l = arr.length;
        System.out.println("Кол-во элементов " + l);

        // формула Эйлера
        int sumByEller = (arr[0] + arr[arr.length - 1]) * (l / 2);
        System.out.println("Сумма рассчитанная по формуле Эйлера: " + sumByEller);

    }

}
