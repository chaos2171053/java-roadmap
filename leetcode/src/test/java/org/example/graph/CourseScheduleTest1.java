package org.example.graph;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest1 {

    @Test
    public void testFindOrder() {
        CourseSchedule1 cs = new CourseSchedule1();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[] result1 = cs.findOrder(numCourses1, prerequisites1);
        assertArrayEquals(new int[]{0, 1}, result1);

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result2 = cs.findOrder(numCourses2, prerequisites2);
        assertTrue(Arrays.equals(result2, new int[]{0, 1, 2, 3}) || Arrays.equals(result2, new int[]{0, 2, 1, 3}));

        int numCourses3 = 1;
        int[][] prerequisites3 = {};
        int[] result3 = cs.findOrder(numCourses3, prerequisites3);
        assertArrayEquals(new int[]{0}, result3);
    }

    @Test
    public void testFindOrderWithCycle() {
        CourseSchedule1 cs = new CourseSchedule1();

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int[] result = cs.findOrder(numCourses, prerequisites);
        assertArrayEquals(new int[0], result);
    }
}
