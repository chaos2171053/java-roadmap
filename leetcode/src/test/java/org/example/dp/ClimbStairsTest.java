package org.example.dp;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClimbStairsTest {
    @Test
    public void testClimbStairsWith2Steps() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertEquals(2, climbStairs.climbStairs(2));
    }

    @Test
    public void testClimbStairsWith3Steps() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertEquals(3, climbStairs.climbStairs(3));
    }

    @Test
    public void testClimbStairsWith4Steps() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertEquals(5, climbStairs.climbStairs(4));
    }

    @Test
    public void testClimbStairsWith5Steps() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertEquals(8, climbStairs.climbStairs(5));
    }

    @Test
    public void testClimbStairsWith6Steps() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertEquals(13, climbStairs.climbStairs(6));
    }
}

