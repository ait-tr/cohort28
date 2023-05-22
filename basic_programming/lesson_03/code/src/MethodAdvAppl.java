
public class MethodAdvAppl {
	public static void main(String[] args) {
		double res = pi();
		System.out.println(res);
		printPi(res);
		res = circleLength(10);
		System.out.println(res);
		res = circleLength(25);
		System.out.println(res);
	}

	public static double circleLength(double radius) {
		// double result = 2 * pi() * radius;
		// return result;
		return 2 * pi() * radius;
	}

	public static void printPi(double pi) {
		System.out.print("PI = ");
		System.out.println(pi);
	}

	public static double pi() {
		double res = 3.1415926;
		return res;
	}
}
