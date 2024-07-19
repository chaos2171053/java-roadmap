package org.example.TrieTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    private Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void testInsertAndSearch() {
        trie.insert("apple");
        assertTrue(trie.search("apple"));   // Returns true
        assertFalse(trie.search("app"));    // Returns false
        assertTrue(trie.startsWith("app")); // Returns true

        trie.insert("app");
        assertTrue(trie.search("app"));     // Returns true
    }

    @Test
    public void testStartsWith() {
        trie.insert("banana");
        assertTrue(trie.startsWith("ban"));    // Returns true
        assertFalse(trie.startsWith("banaanaa")); // Returns false

        trie.insert("band");
        assertTrue(trie.startsWith("band"));   // Returns true
        assertTrue(trie.startsWith("ba"));     // Returns true
    }

    @Test
    public void testSearchNonExistingWord() {
        assertFalse(trie.search("pear"));  // Returns false
        trie.insert("peach");
        assertFalse(trie.search("pea"));   // Returns false
        assertTrue(trie.startsWith("pea")); // Returns true
    }

    @Test
    public void testEmptyString() {
        assertFalse(trie.search(""));      // Returns false
        assertFalse(trie.startsWith(""));  // Returns false

        trie.insert("");
        assertTrue(trie.search(""));       // Returns true
        assertTrue(trie.startsWith(""));   // Returns true
    }
}