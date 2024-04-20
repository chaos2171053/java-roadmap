package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntegerTest {

    @Test
    public void testIII() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("III");
        assertEquals(3, result);
    }

    @Test
    public void testIV() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("IV");
        assertEquals(4, result);
    }

    @Test
    public void testIX() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("IX");
        assertEquals(9, result);
    }

    @Test
    public void testLVIII() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("LVIII");
        assertEquals(58, result);
    }

    @Test
    public void testMCMXCIV() {
        RomanToInteger converter = new RomanToInteger();
        int result = converter.romanToInt("MCMXCIV");
        assertEquals(1994, result);
    }
}