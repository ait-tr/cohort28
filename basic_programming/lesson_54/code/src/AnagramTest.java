package ait.words.test;

import static ait.words.utils.Anagram.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
    String word = "electricity";

    @Test
    void testIsAnangram(){
        assertTrue(isAnagram(word, "city"));
        assertTrue(isAnagram(word, "tic"));
        assertTrue(isAnagram(word, "City"));
        assertTrue(isAnagram(word, "rele"));
        assertTrue(isAnagram(word, "tele"));
    }

    @Test
    void testIsNotAnagram() {
        assertFalse(isAnagram(word, "tell"));
        assertFalse(isAnagram(word, "select"));
        assertFalse(isAnagram(word, "collect"));
        assertFalse(isAnagram(word, ""));
        assertFalse(isAnagram(word, null));
    }
}