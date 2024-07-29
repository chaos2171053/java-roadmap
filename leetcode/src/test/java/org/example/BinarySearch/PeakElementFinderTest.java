package org.example.BinarySearch;


import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PeakElementFinderTest {

    private final PeakElementFinder peakElementFinder = new PeakElementFinder();

    @Test
    public void testFindPeakElementExample1() {
        int[] nums = {1, 2, 3, 1};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 2);
    }

    @Test
    public void testFindPeakElementExample2() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 1 || peakIndex == 5);
    }

    @Test
    public void testFindPeakElementSingleElement() {
        int[] nums = {1};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 0);
    }

    @Test
    public void testFindPeakElementTwoElements() {
        int[] nums = {1, 2};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 1);
    }

    @Test
    public void testFindPeakElementThreeElements() {
        int[] nums = {2, 1, 2};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 0 || peakIndex == 2);
    }

    @Test
    public void testFindPeakElementLargeArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int peakIndex = peakElementFinder.findPeakElement(nums);
        assertTrue(peakIndex == 14);
    }
}
