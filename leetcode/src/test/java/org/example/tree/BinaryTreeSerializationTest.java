package org.example.tree;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeSerializationTest {

    @Test
    public void testSerializeAndDeserialize() {
        // 创建二叉树示例
        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 序列化二叉树
        BinaryTreeSerialization solution = new BinaryTreeSerialization();
        String serialized = solution.serialize(root);

        // 验证序列化结果
        String expectedSerialized = "1,2,4,null,null,null,3,5,null,null,6,null,null,";
        assertEquals(expectedSerialized, serialized);

        // 反序列化二叉树
        TreeNode deserializedRoot = solution.deserialize(serialized);

        // 验证反序列化结果
        assertEquals(1, deserializedRoot.val);
        assertEquals(2, deserializedRoot.left.val);
        assertEquals(3, deserializedRoot.right.val);
        assertEquals(4, deserializedRoot.left.left.val);
        assertEquals(5, deserializedRoot.right.left.val);
        assertEquals(6, deserializedRoot.right.right.val);
    }
}
