package org.example.hashmap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsomorphicStringsTest {

    private final IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

    @Test
    public void testIsIsomorphic1() {
        String s = "egg";
        String t = "add";
        assertTrue(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic2() {
        String s = "foo";
        String t = "bar";
        assertFalse(isomorphicStrings.isIsomorphic(s, t));
    }

    @Test
    public void testIsIsomorphic3() {
        String s = "paper";
        String t = "title";
        assertTrue(isomorphicStrings.isIsomorphic(s, t));
    }
}
