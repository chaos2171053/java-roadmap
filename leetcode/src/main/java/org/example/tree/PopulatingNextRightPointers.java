package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    // 定义二叉树节点类
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void populateNext(PopulatingNextRightPointers.Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 将该层最后一个节点的 next 指针设置为 null
            prev.next = null;
        }
    }
}
