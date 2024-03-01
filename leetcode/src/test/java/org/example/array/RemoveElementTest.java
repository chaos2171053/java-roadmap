package org.example.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveElementTest {

    @Test
    public void testRemoveElement_NormalCase() {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expectedLength = 2; // 移除所有值为3的元素后，数组的新长度为2
        int newLength = removeElement.removeElement(nums, val);
        assertEquals(expectedLength, newLength);
        //System.out.println("===out nums===: "+ Arrays.toString(nums));
//        int[] expectedArray = {2, 2}; // 移除所有值为3的元素后，数组变为 {2, 2}
//        int[] newArray = Arrays.copyOf(nums, newLength);
//        assertArrayEquals(expectedArray, newArray);
    }

    @Test
    public void testRemoveElement_AllElementsSameAsVal() {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {2, 2, 2, 2};
        int val = 2;
        int expectedLength = 0; // 移除所有值为2的元素后，数组的新长度为0
        int newLength = removeElement.removeElement(nums, val);
        assertEquals(expectedLength, newLength);
        int[] expectedArray = {}; // 移除所有值为2的元素后，数组为空
        int[] newArray = Arrays.copyOf(nums, newLength);
        assertArrayEquals(expectedArray, newArray);
    }

    @Test
    public void testRemoveElement_NoElementEqualToVal() {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {1, 2, 3, 4};
        int val = 5;
        int expectedLength = 4; // 没有值等于5的元素，数组的长度不变
        int newLength = removeElement.removeElement(nums, val);
        assertEquals(expectedLength, newLength);
        int[] expectedArray = {1, 2, 3, 4}; // 数组不变
        int[] newArray = Arrays.copyOf(nums, newLength);
        assertArrayEquals(expectedArray, newArray);
    }
}

