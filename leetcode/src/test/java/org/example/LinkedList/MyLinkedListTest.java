package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

    @Test
    public void testMyLinkedList_AddGet() {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        assertEquals(1, obj.get(0));
        assertEquals(2, obj.get(1));
        assertEquals(3, obj.get(2));
    }

    @Test
    public void testMyLinkedList_DeleteAtIndex() {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        obj.deleteAtIndex(1);
        assertEquals(1, obj.get(0));
        assertEquals(3, obj.get(1));
    }
}


