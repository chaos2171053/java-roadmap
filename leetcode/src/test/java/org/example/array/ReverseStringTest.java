package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ReverseStringTest {

    @Test
    public void testReverseString_EvenLength() {
        ReverseString reverser = new ReverseString();

        // 测试用例1：偶数长度的字符串
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] expected1 = {'o', 'l', 'l', 'e', 'h'};
        reverser.reverseString(s1);
        assertArrayEquals(expected1, s1);

        // 测试用例2：偶数长度的字符串
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expected2 = {'h', 'a', 'n', 'n', 'a', 'H'};
        reverser.reverseString(s2);
        assertArrayEquals(expected2, s2);
    }

    @Test
    public void testReverseString_OddLength() {
        ReverseString reverser = new ReverseString();

        // 测试用例3：奇数长度的字符串
        char[] s3 = {'c', 'o', 'd', 'e'};
        char[] expected3 = {'e', 'd', 'o', 'c'};
        reverser.reverseString(s3);
        assertArrayEquals(expected3, s3);

        // 测试用例4：奇数长度的字符串
        char[] s4 = {'J', 'a', 'v', 'a'};
        char[] expected4 = {'a', 'v', 'a', 'J'};
        reverser.reverseString(s4);
        assertArrayEquals(expected4, s4);
    }
}
