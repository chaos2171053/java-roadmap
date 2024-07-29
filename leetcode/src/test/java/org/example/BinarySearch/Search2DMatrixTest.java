package org.example.BinarySearch;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Search2DMatrixTest {

    private final Search2DMatrix search2DMatrix = new Search2DMatrix();

    @Test
    public void testSearchMatrixExample1() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        assertTrue(search2DMatrix.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrixExample2() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 13;
        assertFalse(search2DMatrix.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrixWithSingleElement() {
        int[][] matrix = {
                {1}
        };
        int target = 1;
        assertTrue(search2DMatrix.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrixWithSingleElementNotFound() {
        int[][] matrix = {
                {1}
        };
        int target = 2;
        assertFalse(search2DMatrix.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrixEmptyMatrix() {
        int[][] matrix = {};
        int target = 1;
        assertFalse(search2DMatrix.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrixNotFoundInMatrix() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 35;
        assertFalse(search2DMatrix.searchMatrix(matrix, target));
    }
}
