package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HIndexTest {

    @Test
    public void testHIndex() {
        HIndex hIndexCalculator = new HIndex();

        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 3, 1};

        assertEquals(3, hIndexCalculator.hIndex(citations1));
        assertEquals(1, hIndexCalculator.hIndex(citations2));
    }
}