package practice;

public class WeekDays {
    public static void main(String[] args) {
//        Сформируйте массив, который хранит названия дней недели при условии, что первый
//        рабочий день недели - это Понедельник, а последний - Воскресенье.
//        Переопределите этот массив так, чтобы первым рабочим днем недели стало
//        Воскресенье, а последним - Суббота.

        // объявим массив
        String[] daysOfWeek = new String[7];

        // заполняем массив поэлементно
        daysOfWeek[0] = "Monday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[1] = "Tuesday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[2] = "Wednesday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[3] = "Thursday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[4] = "Friday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[5] = "Saturday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0
        daysOfWeek[6] = "Sunday"; // - определили, присвоили 1-й элемент массива, у него индекс = 0

        String[] week = { "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"}; // - второй вариант заполнения массива

        printArray(week); // печатаем


            // будем в цикле "переселять" элементы массива, 0-й должен стать 1-м, 1-й - должен стать 2-м и т.д.
            // чтобы не потерять значение элемента будем использовать переменную temp
            // может начнем с последнего элемента? пойдем от 6 -> до 1

        String temp = week[week.length - 1]; // убрали последний элемент в tem

        for (int i = week.length - 1 ; i > 0; i--) { // идем по массиву справа налево
            week[i] = week[i - 1]; // сдвигаем элементы массива
        }
        week[0] = temp; // последний элемент поставили в начало

        printArray(week); // печатаем массив

    }
    public static void printArray (String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}
