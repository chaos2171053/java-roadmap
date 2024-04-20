package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigZagConversionTest {

    @Test
    public void testConvertWithExample1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        assertEquals(expected, convert(s, numRows));
    }

    @Test
    public void testConvertWithExample2() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        assertEquals(expected, convert(s, numRows));
    }

    @Test
    public void testConvertWithExample3() {
        String s = "A";
        int numRows = 1;
        String expected = "A";
        assertEquals(expected, convert(s, numRows));
    }

    private String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        int step = 1;

        for (char ch : s.toCharArray()) {
            rows[index].append(ch);

            if (index == 0) {
                step = 1;
            } else if (index == numRows - 1) {
                step = -1;
            }

            index += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
