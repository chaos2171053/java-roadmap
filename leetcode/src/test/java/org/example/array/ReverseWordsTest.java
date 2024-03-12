package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    @Test
    public void testReverseWords_MultipleWords() {
        ReverseWords solution = new ReverseWords();

        // 测试用例1：普通情况，包含多个单词
        String s1 = "hello world labuladong";
        String expected1 = "labuladong world hello";
        String result1 = solution.reverseWords(s1);
        assertEquals(expected1, result1);
    }

    @Test
    public void testReverseWords_SingleWord() {
        ReverseWords solution = new ReverseWords();

        // 测试用例2：只有一个单词
        String s2 = "leetcode";
        String expected2 = "leetcode";
        String result2 = solution.reverseWords(s2);
        assertEquals(expected2, result2);
    }

    @Test
    public void testReverseWords_EmptyString() {
        ReverseWords solution = new ReverseWords();

        // 测试用例3：空字符串
        String s3 = "";
        String expected3 = "";
        String result3 = solution.reverseWords(s3);
        assertEquals(expected3, result3);
    }
}


