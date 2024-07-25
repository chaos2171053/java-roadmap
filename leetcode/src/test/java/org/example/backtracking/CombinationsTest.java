package org.example.backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationsTest {

    @Test
    public void testCombine_n4_k2() {
        Combinations solver = new Combinations();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4)
        );
        assertEquals(expected, solver.combine(4, 2));
    }

    @Test
    public void testCombine_n1_k1() {
        Combinations solver = new Combinations();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected, solver.combine(1, 1));
    }

    @Test
    public void testCombine_n5_k3() {
        Combinations solver = new Combinations();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 3, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(1, 4, 5),
                Arrays.asList(2, 3, 4),
                Arrays.asList(2, 3, 5),
                Arrays.asList(2, 4, 5),
                Arrays.asList(3, 4, 5)
        );
        assertEquals(expected, solver.combine(5, 3));
    }

    @Test
    public void testCombine_n3_k1() {
        Combinations solver = new Combinations();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3)
        );
        assertEquals(expected, solver.combine(3, 1));
    }

    @Test
    public void testCombine_n4_k4() {
        Combinations solver = new Combinations();
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3, 4)
        );
        assertEquals(expected, solver.combine(4, 4));
    }
}
