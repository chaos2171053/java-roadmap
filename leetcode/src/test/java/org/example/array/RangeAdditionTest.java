package org.example.array;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class RangeAdditionTest {

    @Test
    public void testGetModifiedArray() {
        RangeAddition solution = new RangeAddition();

        // 测试用例
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] expected = {-2,0,3,5,3};
        int[] result = solution.getModifiedArray(length, updates);

        // 断言结果是否符合预期
        assertArrayEquals(expected, result);
    }
}
