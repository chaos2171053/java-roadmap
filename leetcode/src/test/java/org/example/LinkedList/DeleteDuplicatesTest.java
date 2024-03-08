package org.example.LinkedList;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeleteDuplicatesTest {

    @Test
    public void testDeleteDuplicates_NoDuplicates() {
        DeleteDuplicates solution = new DeleteDuplicates();

        // 构造无重复元素的已排序链表
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        // 预期的结果应该与原链表一致
        ListNode expected = ListNode.build(new int[]{1, 2, 3, 4, 5});

        // 调用方法
        ListNode result = solution.deleteDuplicates(head);

        // 断言预期结果与实际结果一致
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testDeleteDuplicates_WithDuplicates() {
        DeleteDuplicates solution = new DeleteDuplicates();

        // 构造有重复元素的已排序链表
        ListNode head = ListNode.build(new int[]{1, 1, 2, 3, 3});
        // 期望的结果是删除重复元素后的链表
        ListNode expected = ListNode.build(new int[]{1, 2, 3});

        // 调用方法
        ListNode result = solution.deleteDuplicates(head);

        // 断言预期结果与实际结果一致
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testDeleteDuplicates_EmptyList() {
        DeleteDuplicates solution = new DeleteDuplicates();

        // 构造一个空链表
        ListNode head = null;
        // 期望的结果应该也是一个空链表
        ListNode expected = null;

        // 调用方法
        ListNode result = solution.deleteDuplicates(head);

        // 断言预期结果与实际结果一致
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testDeleteDuplicates_SingleElement() {
        DeleteDuplicates solution = new DeleteDuplicates();

        // 构造只有一个元素的链表
        ListNode head = ListNode.build(new int[]{1});
        // 期望的结果应该也是只有一个元素的链表
        ListNode expected = ListNode.build(new int[]{1});

        // 调用方法
        ListNode result = solution.deleteDuplicates(head);

        // 断言预期结果与实际结果一致
        assertTrue(ListNode.compare(expected, result));
    }
}
