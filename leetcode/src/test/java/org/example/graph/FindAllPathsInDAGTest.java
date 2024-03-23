package org.example.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindAllPathsInDAGTest {

    @Test
    public void testFindAllPaths() {
        // 构建一个有向无环图
        List<Integer>[] graph = new ArrayList[4];
        graph[0] = new ArrayList<>();
        graph[0].add(1);
        graph[0].add(2);
        graph[1] = new ArrayList<>();
        graph[1].add(3);
        graph[2] = new ArrayList<>();
        graph[2].add(3);
        graph[3] = new ArrayList<>();

        // 预期的路径
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> path1 = new ArrayList<>();
        path1.add(0);
        path1.add(1);
        path1.add(3);
        List<Integer> path2 = new ArrayList<>();
        path2.add(0);
        path2.add(2);
        path2.add(3);
        expected.add(path1);
        expected.add(path2);

        // 测试寻找所有路径的方法
        List<List<Integer>> result = FindAllPathsInDAG.findAllPaths(graph);

        // 验证结果是否正确
        assertEquals(expected.size(), result.size());
        for (List<Integer> exp : expected) {
            boolean found = false;
            for (List<Integer> res : result) {
                if (exp.equals(res)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                assertEquals(exp, null); // 如果找不到预期的路径，触发断言失败
            }
        }
    }
}

