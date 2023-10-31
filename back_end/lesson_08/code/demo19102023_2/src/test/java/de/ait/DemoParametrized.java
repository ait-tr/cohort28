package de.ait;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class DemoParametrized {
    @ParameterizedTest(name="test 1: {arguments}")
    @ValueSource(strings = {"1a","2a","3a"})
    void test1(String str){
        Assertions.assertTrue(str.endsWith("a"));
    }

    @ParameterizedTest(name="test 1: {arguments}")
    @CsvFileSource(resources = "/data.csv")
    void test2(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }

    @ParameterizedTest(name="test 1: int: {0} str:{1}")
    @CsvSource({"1,qwe","2,qwe1","2,2"})
    void test3(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }

    @ParameterizedTest(name="test 1: int: {0} str:{1}")
    @MethodSource("argsProviderMethod")
    void test4(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }

    public static Stream<Arguments>  argsProviderMethod() {
        return Stream.of(
                Arguments.of(1,"ret"),
                Arguments.of(1,"1"),
                Arguments.of(2,"2")
        );
    }

}
