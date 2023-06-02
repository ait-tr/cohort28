public class MainReverseArray {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Создаём массив целых чисел
        System.out.print("Исходный массив: ");
        // напечатали массив
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println(); //

        reverseArray(numbers);   // Используем метод reverseArray для разворота массива
        // печать массива
        System.out.print("Развёрнутый массив: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t"); // печатем элементы массива через табуляцию
        }
    }
    // __________Methods__________________
    public static void reverseArray(int[] array) {
        if (array == null || array.length <= 1) {
            System.out.println("Wrong imput data, array is empty");
            return; // Проверяем, чтобы массив не был равен нулю ИЛИ число элементов массива не было меньше 1
        }
        for (int i = 0; i < array.length / 2; i++) { // Используем цикл, который выполняется до середины массива
            int temp = array[i]; // убираем текущий элемент массива в temp
            array[i] = array[array.length - 1 - i]; // Чтобы двигаться от правого элемента влево используем ( - 1 - i)
            //На каждой итерации мы меняем значения элементов массива, используя временную переменную temp.
            array[array.length - 1 - i] = temp;
        }
    }
    //__________end of Methods____________
}