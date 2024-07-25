package org.example.backtracking;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class PhoneNumberCombinationsTest {

    @Test
    public void testLetterCombinations_TwoDigits() {
        PhoneNumberCombinations solver = new PhoneNumberCombinations();
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertEquals(expected, solver.letterCombinations("23"));
    }

    @Test
    public void testLetterCombinations_EmptyInput() {
        PhoneNumberCombinations solver = new PhoneNumberCombinations();
        List<String> expected = Arrays.asList();
        assertEquals(expected, solver.letterCombinations(""));
    }

    @Test
    public void testLetterCombinations_SingleDigit() {
        PhoneNumberCombinations solver = new PhoneNumberCombinations();
        List<String> expected = Arrays.asList("a", "b", "c");
        assertEquals(expected, solver.letterCombinations("2"));
    }

    @Test
    public void testLetterCombinations_DuplicateDigits() {
        PhoneNumberCombinations solver = new PhoneNumberCombinations();
        List<String> expected = Arrays.asList("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc");
        assertEquals(expected, solver.letterCombinations("22"));
    }
}
