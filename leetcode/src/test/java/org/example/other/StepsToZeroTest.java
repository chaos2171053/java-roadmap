package org.example.other;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StepsToZeroTest {

    @Test
    public void testNumberOfSteps1() {
        StepsToZero solution = new StepsToZero();
        assertEquals(6, solution.numberOfSteps(14));
    }

    @Test
    public void testNumberOfSteps2() {
        StepsToZero solution = new StepsToZero();
        assertEquals(4, solution.numberOfSteps(8));
    }



    @Test
    public void testNumberOfSteps4() {
        StepsToZero solution = new StepsToZero();
        assertEquals(0, solution.numberOfSteps(0));
    }
}

