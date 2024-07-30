package org.example.binary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryAdderTest {
    @Test
    public void testAddBinary1() {
        BinaryAdder adder = new BinaryAdder();
        String a = "11";
        String b = "1";
        String expected = "100";
        String result = adder.addBinary(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testAddBinary2() {
        BinaryAdder adder = new BinaryAdder();
        String a = "1010";
        String b = "1011";
        String expected = "10101";
        String result = adder.addBinary(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testAddBinary3() {
        BinaryAdder adder = new BinaryAdder();
        String a = "0";
        String b = "0";
        String expected = "0";
        String result = adder.addBinary(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testAddBinary4() {
        BinaryAdder adder = new BinaryAdder();
        String a = "1";
        String b = "0";
        String expected = "1";
        String result = adder.addBinary(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testAddBinary5() {
        BinaryAdder adder = new BinaryAdder();
        String a = "1111";
        String b = "1111";
        String expected = "11110";
        String result = adder.addBinary(a, b);
        assertEquals(expected, result);
    }
}
