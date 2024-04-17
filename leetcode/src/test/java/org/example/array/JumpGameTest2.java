package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JumpGameTest2 {

    @Test
    public void testJump1() {
        JumpGame2 jumpGame = new JumpGame2();
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int result = jumpGame.jump(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testJump2() {
        JumpGame2 jumpGame = new JumpGame2();
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        int result = jumpGame.jump(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testJump3() {
        JumpGame2 jumpGame = new JumpGame2();
        int[] nums = {3, 2, 1, 0, 4};
        int expected = 0;  // Cannot reach the end
        int result = jumpGame.jump(nums);
        assertEquals(expected, result);
    }
}
