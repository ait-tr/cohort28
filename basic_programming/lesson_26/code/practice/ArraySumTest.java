package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArraySumTest {

    ArraySum arraySum; // создаем экземпляр класса

    @BeforeEach // перед каждым тестом создаем "числый, свежий" экземпляр объекта класса
    void setUp() {
        arraySum = new ArraySum();
    }

    @Test
    void testSumElOddInd(){
        int[] arr = {10, 20, -30, 40};; // тестовые данные
        arraySum.sumElOddInd(arr); // вызов метода из тестируемого класса
        assertEquals( 60, arraySum.sumElOddInd(arr));
    }

}
