package org.example.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimplifyPathTest {
    @Test
    public void testSimplifyPath_Example1() {
        SimplifyPath solution = new SimplifyPath();
        String path = "/home/";
        String expected = "/home";
        String result = solution.simplifyPath(path);
        assertEquals(expected, result);
    }

    @Test
    public void testSimplifyPath_Example2() {
        SimplifyPath solution = new SimplifyPath();
        String path = "/../";
        String expected = "/";
        String result = solution.simplifyPath(path);
        assertEquals(expected, result);
    }

    @Test
    public void testSimplifyPath_Example3() {
        SimplifyPath solution = new SimplifyPath();
        String path = "/home//foo/";
        String expected = "/home/foo";
        String result = solution.simplifyPath(path);
        assertEquals(expected, result);
    }

    @Test
    public void testSimplifyPath_Example4() {
        SimplifyPath solution = new SimplifyPath();
        String path = "/a/./b/../../c/";
        String expected = "/c";
        String result = solution.simplifyPath(path);
        assertEquals(expected, result);
    }
}
