
public class ArrayRefAppl {
	public static void main(String[] args) {
		int x = 10;
		System.out.println("x before = " + x);
		pow2Var(x);
		System.out.println("x after = " + x);
		int[] arr = { 1, 2, 3 };
		System.out.println("arr[1] before = " + arr[1]);
		pow2Arr(arr);
		System.out.println("arr[1] after = " + arr[1]);
		System.out.println(arr);
	}

	public static void pow2Arr(int[] arr) {
		arr[1] = arr[1] * arr[1];
		System.out.println("arr[1] into = " + arr[1]);
	}

	public static void pow2Var(int x) {
		x = x * x;
		System.out.println("x into = " + x);
	}
}
