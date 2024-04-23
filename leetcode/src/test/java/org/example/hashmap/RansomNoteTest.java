package org.example.hashmap;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RansomNoteTest {

    private final RansomNote ransomNote = new RansomNote();

    @Test
    public void testCanConstruct1() {
        String ransomNoteStr = "a";
        String magazineStr = "b";
        assertFalse(ransomNote.canConstruct(ransomNoteStr, magazineStr));
    }

    @Test
    public void testCanConstruct2() {
        String ransomNoteStr = "aa";
        String magazineStr = "ab";
        assertFalse(ransomNote.canConstruct(ransomNoteStr, magazineStr));
    }

    @Test
    public void testCanConstruct3() {
        String ransomNoteStr = "aa";
        String magazineStr = "aab";
        assertTrue(ransomNote.canConstruct(ransomNoteStr, magazineStr));
    }
}

