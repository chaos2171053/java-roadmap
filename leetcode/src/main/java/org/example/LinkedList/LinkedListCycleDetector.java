package org.example.LinkedList;


public class LinkedListCycleDetector {
    // 测试链表是否包含环的
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {

            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return  true;
            }
        }
        // 慢指针指向中点
        return false;
    }

//    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//    为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
//    如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//    不允许修改 链表。
    public ListNode detectCycleStart(ListNode head) {

        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {

            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                break;
            }
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        slow = head;
        while(slow!=fast){
            slow=slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
