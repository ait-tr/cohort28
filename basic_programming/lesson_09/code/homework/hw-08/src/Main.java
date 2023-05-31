public class Main {
    public static void main(String[] args) {
        System.out.println("Array practicum - task 2");
        // Задача 2. Написать метод, принимающий массив целых чисел, и возвращающий сумму всех его нечетных элементов.

//        Алгоритм:
//        Шаг 1 - объявить/создать массив, тип int[10]
//        Шаг 2 - внести данные (включить фантазию - придумать начальные данные)
//        Шаг 3 - ключевой оператор - это цикл for
//        Шаг 4 - пробегаем по индексам i от первого 0 до arr.length
//        Как найти нечетный элемент? - индекс элемента (arr[i] % 2 != 0) - это для условия внутри if
//        Внутри цикла печатаем элементы массива arr[i]

        int[] arr = new int[10]; // объявление массива
        // присваиваем значения элементам массива
        arr[0] = 12;
        arr[1] = -7;
        arr[2] = -5;
        arr[3] = 5;
        arr[4] = -8;
        arr[5] = -9;
        arr[6] = 25;
        arr[7] = 3;
        arr[8] = 17;
        arr[9] = 52;

        int[] abc = {1, 2, 3, 5, 4, 6, 7, 9, 11, 12, 18, 17}; // это другой массив

//        int sum = 0;
//
//        for (int i = 0; i < 10; i++) {
//            if (arr[i] % 2 !=0 ) {
//                sum = sum + arr[i];
//            }
//        }

        int s = sumOfEvenElements(arr); // вызов метода и передаем ему аргументом массив arr

        int sabc = sumOfEvenElements(abc); // вызов метода и передаем ему аргументом массив abc

        System.out.println("Sum of even elements of array arr is: " + s);
        System.out.println();
        System.out.println("Sum of even elements of array abc is: " + sabc);

    }

    // ___________Methods________
    public static int sumOfEvenElements (int array[]){
        int sum = 0;
        for (int i = 0; i < array.length; i++) { // пробегаем по индексам от 0 до последнего array.length - 1
            if (array[i] % 2 !=0 ) {
                sum = sum + array[i];
            }
        }
      return sum;
    }

    // __________end of Methods
}