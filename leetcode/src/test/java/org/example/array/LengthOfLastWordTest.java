package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWordTest {

    @Test
    public void testLengthOfLastWord_Example1() {
        assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello World"));
    }

    @Test
    public void testLengthOfLastWord_Example2() {
        assertEquals(4, LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    }

    @Test
    public void testLengthOfLastWord_Example3() {
        assertEquals(6, LengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
    }

    @Test
    public void testLengthOfLastWord_EmptyString() {
        assertEquals(0, LengthOfLastWord.lengthOfLastWord(""));
    }

    @Test
    public void testLengthOfLastWord_OneWord() {
        assertEquals(4, LengthOfLastWord.lengthOfLastWord("word"));
    }
}
