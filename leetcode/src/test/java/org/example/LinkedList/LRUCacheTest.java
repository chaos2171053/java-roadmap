package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {


    @Test
    public void testLRUCache() {
        LRUCache lRUCache = new LRUCache(2);
        assertEquals(-1, lRUCache.get(1)); // Cache is empty, expected -1

        lRUCache.put(1, 1); // Cache is {1=1}
        assertEquals(1, lRUCache.get(1)); // Expected 1

        lRUCache.put(2, 2); // Cache is {1=1, 2=2}
        assertEquals(1, lRUCache.get(1)); // Expected 1

        lRUCache.put(3, 3); // Cache is {1=1, 3=3} (2 evicted)
        assertEquals(-1, lRUCache.get(2)); // 2 is evicted, expected -1

        lRUCache.put(4, 4); // Cache is {4=4, 3=3} (1 evicted)
        assertEquals(-1, lRUCache.get(1)); // 1 is evicted, expected -1
        assertEquals(3, lRUCache.get(3)); // Expected 3
        assertEquals(4, lRUCache.get(4)); // Expected 4
    }
}