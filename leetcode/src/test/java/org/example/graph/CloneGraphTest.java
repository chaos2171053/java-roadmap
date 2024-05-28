package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.*;


//给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//
//        图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。


//
//测试用例格式：
//
//简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
//
//邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
//
//给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
//
//
//
//示例 1：
//
//
//
//输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
//输出：[[2,4],[1,3],[2,4],[1,3]]
//解释：
//图中有 4 个节点。
//节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
//节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
//节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
//节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
//示例 2：
//
//
//
//输入：adjList = [[]]
//输出：[[]]
//解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
//示例 3：
//
//输入：adjList = []
//输出：[]
//解释：这个图是空的，它不含任何节点。
public class CloneGraphTest {
    @Test
    public void testCloneGraph() {
        CloneGraph CloneGraph = new CloneGraph();

        // Test case 1: Standard case with a connected graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = CloneGraph.cloneGraph(node1);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(2, clonedGraph.neighbors.size());

        Node cloneNode2 = clonedGraph.neighbors.get(0).val == 2 ? clonedGraph.neighbors.get(0) : clonedGraph.neighbors.get(1);
        Node cloneNode4 = clonedGraph.neighbors.get(0).val == 4 ? clonedGraph.neighbors.get(0) : clonedGraph.neighbors.get(1);

        assertNotNull(cloneNode2);
        assertNotNull(cloneNode4);
        assertEquals(2, cloneNode2.val);
        assertEquals(4, cloneNode4.val);

        assertEquals(2, cloneNode2.neighbors.size());
        assertEquals(2, cloneNode4.neighbors.size());

        // Test case 2: Graph with a single node and no neighbors
        Node singleNode = new Node(1);
        Node clonedSingleNode = CloneGraph.cloneGraph(singleNode);
        assertNotNull(clonedSingleNode);
        assertEquals(1, clonedSingleNode.val);
        assertTrue(clonedSingleNode.neighbors.isEmpty());

        // Test case 3: Empty graph
        Node emptyGraph = null;
        Node clonedEmptyGraph = CloneGraph.cloneGraph(emptyGraph);
        assertNull(clonedEmptyGraph);
    }

    @Test
    public void testCloneGraphWithDisconnectedComponents() {
        CloneGraph CloneGraph = new CloneGraph();

        // Test case 4: Graph with disconnected components
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        // node3 is a disconnected node

        Node clonedGraph = CloneGraph.cloneGraph(node1);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(1, clonedGraph.neighbors.size());

        Node cloneNode2 = clonedGraph.neighbors.get(0);
        assertNotNull(cloneNode2);
        assertEquals(2, cloneNode2.val);
        assertEquals(1, cloneNode2.neighbors.size());
        assertEquals(1, cloneNode2.neighbors.get(0).val);

        Node clonedDisconnectedNode = CloneGraph.cloneGraph(node3);
        assertNotNull(clonedDisconnectedNode);
        assertEquals(3, clonedDisconnectedNode.val);
        assertTrue(clonedDisconnectedNode.neighbors.isEmpty());
    }
}
