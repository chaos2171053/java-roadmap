package org.example.dp;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriangleMinimumPathSumTest {

    @Test
    public void testMinimumTotal() {
        TriangleMinimumPathSum solution = new TriangleMinimumPathSum();

        List<List<Integer>> triangle1 = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        assertEquals(11, solution.minimumTotal(triangle1));

        List<List<Integer>> triangle2 = Arrays.asList(
                Arrays.asList(-10)
        );
        assertEquals(-10, solution.minimumTotal(triangle2));
    }
}
