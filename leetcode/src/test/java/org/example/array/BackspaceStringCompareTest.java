package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackspaceStringCompareTest {

    @Test
    public void testBackspaceCompare_NormalCase() {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "ab#c";
        String t = "ad#c";
        boolean expected = true; // 两个字符串分别去除退格符后相等
        boolean result = backspaceStringCompare.backspaceCompare(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testBackspaceCompare_EmptyStrings() {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "";
        String t = "";
        boolean expected = true; // 两个空字符串相等
        boolean result = backspaceStringCompare.backspaceCompare(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testBackspaceCompare_OneEmptyString() {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "ab#c";
        String t = "";
        boolean expected = false; // 一个非空字符串和一个空字符串不相等
        boolean result = backspaceStringCompare.backspaceCompare(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testBackspaceCompare_DifferentStrings() {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "a##c";
        String t = "#a#c";
        boolean expected = true; // 两个字符串去除退格符后相等
        boolean result = backspaceStringCompare.backspaceCompare(s, t);
        assertEquals(expected, result);
    }
}
