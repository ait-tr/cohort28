package practice;

public class ArraySum {
    public static void main(String[] args) {
//        Задайте массив на 10 элементов и заполните его случайными числами в интервале от -10 до 10.
//        Распечатайте полученный массив.
//        Найдите сумму элементов массива c нечетными индексами.
//        Разработайте соответсвующий тест (набор тестов).

        int[] array = new int[10]; // определил массив

        int a = -10;
        int b = 10;

        // заполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a); // формула из теории
        }
        printArray(array);
        //      int sum = sumElOddInd(array); // вызов метода для суммирования
     //   System.out.println("Sum of Elements with odd indexes = " + sum);

    }
    // ________Methods________
    public static void printArray (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public int sumElOddInd(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) { // проверка индекса элемента на нечетность
                sum = sum + arr[i]; // накапливаем сумму таких элементов (с нечетными индексами)
            }
        }
        return sum;
    }
    //________end of Methods
}
