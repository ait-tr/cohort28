package consultation;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main1 {
    public static void main(String[] args) {
        // для чисел от -128 до 127 работает IntegerCache
        // для таких чисел boxing не выполняется и просто используется один и тот же объект
        Integer i1 = 56; // используется
        Integer i2 = 56;// один и тот же объект

        Integer i3 = 132;
        Integer i4 = 132;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
