package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MoveZeroesTest {

    @Test
    public void testMoveZeroes_NormalCase() {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0}; // 移动0到末尾后的数组
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroes_AllZeroes() {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0}; // 数组中所有元素都是0
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroes_NoZeroes() {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5}; // 数组中没有0
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMoveZeroes_EmptyArray() {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {};
        int[] expected = {}; // 空数组
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }
}
