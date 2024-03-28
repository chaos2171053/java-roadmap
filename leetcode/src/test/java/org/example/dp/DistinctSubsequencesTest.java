package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DistinctSubsequencesTest {

    @Test
    public void testDistinctSubsequences() {
        DistinctSubsequences solution = new DistinctSubsequences();

        // 测试用例 1
        String s1 = "rabbbit";
        String t1 = "rabbit";
        int expected1 = 3; // 预期结果
        int result1 = solution.numDistinct(s1, t1);
        assertEquals(expected1, result1);

        // 测试用例 2
        String s2 = "babgbag";
        String t2 = "bag";
        int expected2 = 5; // 预期结果
        int result2 = solution.numDistinct(s2, t2);
        assertEquals(expected2, result2);
    }
}

