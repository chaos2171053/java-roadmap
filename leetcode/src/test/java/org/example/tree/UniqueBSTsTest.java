package org.example.tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueBSTsTest {

    @Test
    public void testUniqueBSTs_nEquals1() {
        // 测试n为1时的情况
        assertEquals(1, UniqueBSTs.numTrees(1));
    }

    @Test
    public void testUniqueBSTs_nEquals2() {
        // 测试n为2时的情况
        assertEquals(2, UniqueBSTs.numTrees(2));
    }

    @Test
    public void testUniqueBSTs_nEquals3() {
        // 测试n为3时的情况
        assertEquals(5, UniqueBSTs.numTrees(3));
    }

    @Test
    public void testUniqueBSTs_nEquals4() {
        // 测试n为4时的情况
        assertEquals(14, UniqueBSTs.numTrees(4));
    }
}

