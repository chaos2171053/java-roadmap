package org.example.array;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionPickIndexTest {

    @Test
    public void testPickIndex_SingleElement() {
        SolutionPickIndex solution = new SolutionPickIndex(new int[]{1});
        assertEquals(0, solution.pickIndex());
    }

    @Test
    public void testPickIndex_MultipleElements() {
        SolutionPickIndex solution = new SolutionPickIndex(new int[]{1, 3});
        int[] counts = new int[2];
        for (int i = 0; i < 1000; i++) {
            int index = solution.pickIndex();
            counts[index]++;
        }
        assertEquals(250, counts[0], 25);
        assertEquals(750, counts[1], 25);
    }
}

