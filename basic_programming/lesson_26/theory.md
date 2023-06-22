## JUnit и его использование

1. Ранее мы проверяли правильность работы созданных нами методов, выполняя несколько раз
   аппликацию, с различными наборами исходных данных, и сравнивая результат полученный в консоли
   с ожидаемым. Это очень не удобно. Например любое изменение кода, требует повторения всей
   вышеописанной процедуры заново. Существуют специальные библиотеки, которые позволяют облегчить
   и автоматизировать этот процесс. Одна из самых популярных для Java, это JUnit

2. Работа с JUnit заключается в создании класса с тестами и настройке его.
   В классе в качестве полей мы можем указать объекты для тестирования и необходимые данные.
   В методе помеченном аннотацией @BeforeEach мы даем начальные настройки тестируемому объекту.
   А в методах помеченных аннотацией @Test мы пишем код проверяющий тестируемый объект.
   Проверки осуществляются при помощи методов начинающихся со слова assert... (которых существует
   большое колличество на все случаи), и принимающих для сравнения полученный результат и 
   ожидаемый. Все указанные методы и аннотации предоставляются библиотекой JUnit.
   Каждый метод помеченный аннотацией @Test, по сути является отдельным "мейном".

Примеры кода:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    final String email = "peter@gmail.com";
    final String password = "12345Az!";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidPassword(){
        String validPassword = "qwertY1@";
        user.setPassword(validPassword);
        assertEquals(validPassword, user.getPassword());
    }

    @Test
    void testPasswordLength(){
        String inValidPassword = "wertY1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordUppercase(){
        String inValidPassword = "qwerty1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordLowercase(){
        String inValidPassword = "QWERTY1@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordDigits(){
        String inValidPassword = "qwertYa@";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordSpecialSymbols(){
        String inValidPassword = "qwertY12";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
}
