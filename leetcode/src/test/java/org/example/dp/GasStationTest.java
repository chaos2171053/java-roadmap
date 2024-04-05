package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GasStationTest {

    @Test
    public void test1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, GasStation.canCompleteCircuit(gas, cost));
    }

    @Test
    public void test2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        assertEquals(-1, GasStation.canCompleteCircuit(gas, cost));
    }
}
