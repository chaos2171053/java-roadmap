package org.example.other;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FurthestPointFromOriginTest {

    @Test
    public void testMaxDistance1() {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();
        assertEquals(3, solution.maxDistance("L_RL__R"));
    }

    @Test
    public void testMaxDistance2() {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();
        assertEquals(5, solution.maxDistance("_R__LL_"));
    }

    @Test
    public void testMaxDistance3() {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();
        assertEquals(7, solution.maxDistance("_______"));
    }

    @Test
    public void testMaxDistance4() {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();
        assertEquals(1, solution.maxDistance("R"));
    }

    @Test
    public void testMaxDistance5() {
        FurthestPointFromOrigin solution = new FurthestPointFromOrigin();
        assertEquals(2, solution.maxDistance("L_L"));
    }
}
