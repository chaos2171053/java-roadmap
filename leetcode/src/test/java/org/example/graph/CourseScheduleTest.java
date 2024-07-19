package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {

    @Test
    public void testCanFinish() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        CourseSchedule cs = new CourseSchedule();
        boolean result = cs.canFinish(numCourses, prerequisites);
        assertTrue(result);
    }
    @Test
    public void testCanFinishWithCycle() {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseSchedule cs = new CourseSchedule();
        boolean result = cs.canFinish(numCourses, prerequisites);
        assertTrue(result);
    }
}
