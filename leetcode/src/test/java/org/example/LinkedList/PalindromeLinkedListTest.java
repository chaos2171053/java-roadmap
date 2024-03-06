package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PalindromeLinkedListTest {

    @Test
    public void testIsPalindrome_True() {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // 测试用例1：回文链表
        ListNode head1 = ListNode.build(new int[]{1, 2, 3, 2, 1});
        boolean expected1 = true;
        boolean result1 = solution.isPalindrome(head1);
        assertEquals(expected1, result1);

        // 测试用例2：空链表
        ListNode head2 = null;
        boolean expected2 = true; // 空链表也被认为是回文链表
        boolean result2 = solution.isPalindrome(head2);
        assertEquals(expected2, result2);
    }

    @Test
    public void testIsPalindrome_False() {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // 测试用例3：非回文链表
        ListNode head3 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        boolean expected3 = false;
        boolean result3 = solution.isPalindrome(head3);
        assertEquals(expected3, result3);
    }
}

