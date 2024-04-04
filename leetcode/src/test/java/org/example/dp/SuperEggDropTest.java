package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperEggDropTest {

    @Test
   public void testSuperEggDrop() {
        int k = 3;
        int n = 14;

        assertEquals(4, SuperEggDrop.superEggDrop(k, n));
    }
}
