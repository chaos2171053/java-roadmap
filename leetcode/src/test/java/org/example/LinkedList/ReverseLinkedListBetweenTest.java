package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedListBetweenTest {

    @Test
    public void testReverseBetween() {
        // 创建一个单链表
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        int left = 2, right = 4;

        // 创建预期的反转结果
        ListNode expected = ListNode.build(new int[]{1, 4, 3, 2, 5});

        // 执行反转操作
        ReverseLinkedListBetween solution = new ReverseLinkedListBetween();
        ListNode result = solution.reverseBetween(head, left, right);

        // 检查结果
        while (expected != null && result != null) {
            assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }

        // 确保两个链表都遍历完毕
        assertEquals(expected, result);
    }
}

