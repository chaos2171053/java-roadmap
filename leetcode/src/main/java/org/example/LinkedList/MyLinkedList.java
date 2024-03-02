package org.example.LinkedList;

public class MyLinkedList {
    int size = 0;
    ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode();
    }

    public void addAtHead(int i) {
//        ListNode node = new ListNode(i);
//        node.next = this.head.next;
//        this.head.next = node;
//        this.size++;
        this.addAtIndex(0, i);
    }


    public void addAtTail(int i) {
//        ListNode node = new ListNode(i);
//        ListNode current = this.head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = node;
//        this.size++;
        this.addAtIndex(size, i);
    }

    public void addAtIndex(int i, int i1) {
        if (i > size) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        ListNode current = this.head;
        ListNode node = new ListNode(i1);
        int count = 0;
        while(count<i && current!=null){
            count++;
            current=current.next;
        }
        node.next = current.next;
        current.next = node;
        this.size++;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            return -1;
        }
        ListNode current = this.head.next;
        int count = 0;
        while (current != null) {
            if (i == count) {
                return current.val;
            }
            count++;
            current = current.next;
        }
        return -1;
    }

    public void deleteAtIndex(int i) {
        int count = 0;
        ListNode current = this.head.next;
        ListNode prev = this.head;
        if (i < 0 || i >= size) {
            return;
        }
        while (current != null) {
            if (count == i) {
                prev.next = current.next;
                this.size--;
                break;
            }
            prev = current;
            current = current.next;
            count++;
        }
    }
}
