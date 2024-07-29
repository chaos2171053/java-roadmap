package org.example.backtracking;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void testWordExists1() {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        assertTrue(ws.exist(board, word));
    }

    @Test
    public void testWordExists2() {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        assertTrue(ws.exist(board, word));
    }

    @Test
    public void testWordDoesNotExist() {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        assertFalse(ws.exist(board, word));
    }

    @Test
    public void testEmptyBoard() {
        WordSearch ws = new WordSearch();
        char[][] board = {};
        String word = "A";
        assertFalse(ws.exist(board, word));
    }

    @Test
    public void testSingleCharacterBoardAndWord() {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A'}};
        String word = "A";
        assertTrue(ws.exist(board, word));
    }

    @Test
    public void testSingleCharacterBoardAndDifferentWord() {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A'}};
        String word = "B";
        assertFalse(ws.exist(board, word));
    }
}
