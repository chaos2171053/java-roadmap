package org.example.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextJustificationTest {
    @Test
    public void testExample1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        String[] expected = {"This    is    an", "example  of text", "justification.  "};
        List<String> result = TextJustification.fullJustify(words, maxWidth);
        assertEquals(Arrays.asList(expected), result);
    }

    @Test
    public void testExample2() {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        String[] expected = {"What   must   be", "acknowledgment  ", "shall be        "};
        List<String> result = TextJustification.fullJustify(words, maxWidth);
        assertEquals(Arrays.asList(expected), result);
    }

    @Test
    public void testExample3() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        String[] expected = {"Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  "};
        List<String> result = TextJustification.fullJustify(words, maxWidth);
        assertEquals(Arrays.asList(expected), result);
    }

}
