package org.example.array;

import org.example.dp.GasStation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GasStationTest {

    @Test
    public void testExample1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        GasStation solution = new GasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        GasStation solution = new GasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    public void testSingleStation() {
        int[] gas = {5};
        int[] cost = {4};
        GasStation solution = new GasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(0, result);
    }

    @Test
    public void testNoSolution() {
        int[] gas = {2, 3, 1};
        int[] cost = {3, 1, 2};
        GasStation solution = new GasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }
}