package try_catch_example;



public class ArrayOutOfRange {
    public static void main(String[] args) {

        // есть массив на 5 элементов, попытаться обратиться к 6-му элементу массива

        // int[] numbers = new int[5]; // определили новый массив

        int[] numbers = {23, 16, 18, 15, 7}; // массив на 5 элементов

        System.out.println(numbers[2]);
        try {
            System.out.println(numbers[6]);
        } catch (IndexOutOfBoundsException error){
            System.out.println("Can't reach such index" + error.getMessage());
        }

    }
}
