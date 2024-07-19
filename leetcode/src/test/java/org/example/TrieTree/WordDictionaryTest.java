package org.example.TrieTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordDictionaryTest {
    private WordDictionary wordDictionary;

    @Before
    public void setUp() {
        wordDictionary = new WordDictionary();
    }

    @Test
    public void testWordDictionary() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        assertFalse(wordDictionary.search("pad"));  // Returns false
        assertTrue(wordDictionary.search("bad"));   // Returns true
        assertTrue(wordDictionary.search(".ad"));   // Returns true
        assertTrue(wordDictionary.search("b.."));   // Returns true
    }

    @Test
    public void testEmptyDictionary() {
        assertFalse(wordDictionary.search(""));      // Returns false
        wordDictionary.addWord("");
        assertTrue(wordDictionary.search(""));       // Returns true
    }

    @Test
    public void testWildcards() {
        wordDictionary.addWord("abc");
        wordDictionary.addWord("abd");
        wordDictionary.addWord("abe");

        assertTrue(wordDictionary.search("a.c"));    // Returns true
        assertTrue(wordDictionary.search("ab."));    // Returns true
        assertTrue(wordDictionary.search("a.."));    // Returns true
    }

    @Test
    public void testNonExistingWord() {
        assertFalse(wordDictionary.search("xyz"));  // Returns false
        assertFalse(wordDictionary.search("abf"));  // Returns false
    }
}
