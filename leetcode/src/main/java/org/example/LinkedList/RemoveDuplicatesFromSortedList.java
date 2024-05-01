package org.example.LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                int dupVal = prev.next.val;
                while (prev.next != null && prev.next.val == dupVal) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
        }

        return dummy.next;
    }
}
