package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CheapestFlightsWithinKStopsTest {

    @Test
    void testCheapestFlightsWithinKStops() {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        assertEquals(200, CheapestFlightsWithinKStops.findCheapestPrice(3, flights, src, dst, k));
    }
}
