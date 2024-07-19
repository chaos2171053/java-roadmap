package org.example.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class EvaluateDivisionTest {
    @Test
    public void testCalcEquation() {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations1 = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, solution.calcEquation(equations1, values1, queries1), 1e-5);

        List<List<String>> equations2 = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd"));
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"), Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc"));
        assertArrayEquals(new double[]{3.75, 0.4, 5.0, 0.2}, solution.calcEquation(equations2, values2, queries2), 1e-5);

        List<List<String>> equations3 = Arrays.asList(Arrays.asList("a", "b"));
        double[] values3 = {0.5};
        List<List<String>> queries3 = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"), Arrays.asList("a", "c"), Arrays.asList("x", "y"));
        assertArrayEquals(new double[]{0.5, 2.0, -1.0, -1.0}, solution.calcEquation(equations3, values3, queries3), 1e-5);
    }
}
