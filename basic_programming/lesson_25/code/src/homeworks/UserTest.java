package ait.user.test;

import ait.user.model.User;
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
    void testCorrectEmail() {
        user.setEmail("peter@yahoo.com");
        assertEquals("peter@yahoo.com", user.getEmail());
    }

    @Test
    void testWithoutAt() {
        user.setEmail("peter.yahoo.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testManyAt() {
        user.setEmail("peter@ya@hoo.com");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testDotAfterAt() {
        user.setEmail("peter@yahoocom");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testLastDot() {
        user.setEmail("peter@yahoo.com.");
        assertEquals(email, user.getEmail());
        user.setEmail("peter@yahoo.co.m");
        assertEquals(email, user.getEmail());
    }

    @Test
    void testIncorrectSymbol() {
        user.setEmail("pet!er@yahoo.com");
        assertEquals(email, user.getEmail());
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