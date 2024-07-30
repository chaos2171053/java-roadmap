package org.example.dp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HouseRobberTest {

    @Test
    public void testRobExample1() {
        HouseRobber robber = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, robber.rob(nums));
    }

    @Test
    public void testRobExample2() {
        HouseRobber robber = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        assertEquals(12, robber.rob(nums));
    }

    @Test
    public void testRobEmpty() {
        HouseRobber robber = new HouseRobber();
        int[] nums = {};
        assertEquals(0, robber.rob(nums));
    }

    @Test
    public void testRobSingleHouse() {
        HouseRobber robber = new HouseRobber();
        int[] nums = {5};
        assertEquals(5, robber.rob(nums));
    }

    @Test
    public void testRobTwoHouses() {
        HouseRobber robber = new HouseRobber();
        int[] nums = {1, 2};
        assertEquals(2, robber.rob(nums));
    }
}
