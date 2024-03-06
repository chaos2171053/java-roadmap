package org.example.LinkedList;

// 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
// 回文链表是指正序和倒序排列的元素完全相同的链表。
// 换句话说，如果将链表中的节点值以正序排列和倒序排列后得到的序列完全相同，则该链表是回文链表。
//public class PalindromeLinkedList {
////    public boolean isPalindrome(ListNode head1) {
////        ListNode head2 = head1;
////        ListNode prev = null;
////        ListNode cur = head2;
////        ListNode next = null;
////        while(cur!=null){
////            next = cur.next;
////            cur.next = prev;
////            prev = cur;
////            cur = next;
////        }
////        while(prev!=null){
////            if(prev.val!=head1.val){
////                return false;
////            }
////            head1 = head1.next;
////            prev = prev.next;
////        }
////        return true;
////    }
//
//
//    // 解法一：翻转链表后比较
//    public boolean isPalindrome(ListNode head1) {
//        ListNode head2 = reverseList(head1); // 反转链表
//        while (head1 != null && head2 != null) {
//            if (head1.val != head2.val) { // 比较节点值
//                return false;
//            }
//            head1 = head1.next;
//            head2 = head2.next;
//        }
//        return true;
//    }
//
//    private ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//}

// 解法二：递归和后序遍历
//定义左侧指针 left：在 isPalindrome 方法中，将左侧指针 left 初始化为链表的头节点 head。
//
//递归遍历链表：定义 traverse 方法来递归遍历链表，参数 right 表示当前节点。递归终止条件为 right 为空，如果为空则说明已经到达链表尾部，返回 true。
//
//后序遍历：在递归的过程中，先递归到链表末尾，然后进行后序遍历操作。后序遍历的过程中，将右侧指针 right 不断往后移动，同时与左侧指针 left 指向的节点进行比较，如果值不相等，则返回 false。
//
//更新左侧指针：在后序遍历过程中，每次比较完当前节点后，将左侧指针 left 指向下一个节点，以便下一次比较。
//
//返回结果：最终返回后序遍历过程中比较的结果。
//这种解法的时间复杂度为 O(n)，其中 n 是链表的长度，因为它需要遍历整个链表来进行比较。
// 空间复杂度为 O(n)，因为它使用了递归调用栈的空间，递归的深度最多为链表的长度。

//public class PalindromeLinkedList {
//    // 左侧指针
//    ListNode left;
//
//    public boolean isPalindrome(ListNode head) {
//        left = head;
//        return traverse(head);
//    }
//
//    private boolean traverse(ListNode right) {
//        // 递归终止条件
//        if (right == null) return true;
//        // 后序遍历
//        boolean res = traverse(right.next);
//        // 比较节点值
//        res = res && (right.val == left.val);
//        // 更新左侧指针
//        left = left.next;
//        return res;
//    }
//}

// 优化空间复杂度
// 先通过 双指针技巧 中的快慢指针来找到链表的中点：
// 如果fast指针没有指向null，说明链表长度为奇数，slow还要再前进一步：
// 从slow开始反转后面的链表，现在就可以开始比较回文串了：

public class PalindromeLinkedList {
    boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}