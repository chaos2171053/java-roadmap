package org.example.LinkedList;

public class ReverseKGroupLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            ListNode tail = prev;
            // Check if there are k nodes left
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) return dummy.next;
            }
            ListNode nextHead = tail.next;
            // Reverse the k nodes
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];
            // Connect the reversed part with the previous part
            prev.next = head;
            tail.next = nextHead;
            // Move prev and head pointers for the next iteration
            prev = tail;
            head = tail.next;
        }
        return dummy.next;
    }
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while(prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}
