package ait.comparator.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparatorTest {
    Comparator<Integer> oddEvenComp;

    @BeforeEach
    void setUp() throws Exception {
        oddEvenComp = (n1, n2) -> {
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1 - n2;
            }
            if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2 - n1;
            }
            return 0;
        };
    }

    @Test
    void testOddEvenComparator() {
        Comparator<Integer> oddEvenComp = (n1, n2) -> {
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            return 0;
        };
        Integer[] origin = { 1, 4, 3, 2, 5, 6, 9, 8, 7, 3 };
        Arrays.sort(origin, oddEvenComp);
        System.out.println(Arrays.toString(origin));
    }

    @Test
    void testOddEvenComparatorAdvanced() {
        Comparator<Integer> oddEvenComp = (n1, n2) -> {
            if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            }
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            }
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                return n1 - n2;
            }
            if (n1 % 2 != 0 && n2 % 2 != 0) {
                return n2 - n1;
            }
            return 0;
        };
        Integer[] origin = { 1, 4, 3, 2, 5, 6, 9, 8, 7, 3 };
        Integer[] expected = { 2, 4, 6, 8, 9, 7, 5, 3, 3, 1 };
        Arrays.sort(origin, oddEvenComp);
        assertArrayEquals(expected, origin);
    }
}
