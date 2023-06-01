
public class ArrayAdvAppl {
	public static void main(String[] args) {
		int[] arr = new int[10]; // объявление массива целых чисел, длина 10 элементов
		printArray(arr); //
		fillArray(arr, 10, 99);
		printArray(arr);
		swapFirstLast(arr);
		printArray(arr);
		int index = search(arr, arr[8]);
		System.out.println("Index = " + index);
		int res = maxArray(arr);
		System.out.println("Max = " + res);
	}

	public static int maxArray(int[] arr) {
		int res = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (res < arr[i]) {
				res = arr[i];
			}
		}
		return res;
	}

	public static int search(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public static void swapFirstLast(int[] arr) {
		int t = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = t;
	}

	// min include max include
	public static void fillArray(int[] arr, int min, int max) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (min + Math.random() * (max + 1 - min));
		}
	}

	// Метод печатает массив
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

}
