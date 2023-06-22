package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice.ArraySumElements.sumElements;

public class ArraySumElementsTest {

    ArraySumElements arraySumElements; // создали свежий элемент класса

    @BeforeEach
    void setUp() {
        arraySumElements = new ArraySumElements();
    }

    @Test
   void testSumArrayElements() {
        int[] arr = {10, 20, -30};
        assertEquals(0, sumElements(arr));
    }

}
