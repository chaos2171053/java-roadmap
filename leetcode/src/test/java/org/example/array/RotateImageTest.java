package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class RotateImageTest {

    @Test
    public void testRotate() {
        RotateImage solution = new RotateImage();

        // 测试用例
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        // 旋转图像
        solution.rotate(matrix);

        // 断言结果是否符合预期
        assertArrayEquals(expected, matrix);
    }
}

