package org.example.graph;

import java.util.LinkedList;
import java.util.List;

//给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
//
// graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
public class FindAllPathsInDAG {

    static  List<List<Integer>> res= new LinkedList<>();
    public static List<List<Integer>> findAllPaths(List<Integer>[] graph) {
        LinkedList<Integer> path =  new LinkedList<>();
        traverse(graph,0,path);
        return res;
    }

    private static void traverse(List<Integer>[] graph, int i, LinkedList<Integer> path) {
        // 添加节点 i 到路径
        path.addLast(i);

        int length = graph.length;
        int n = graph.length;
        if (i == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }

        // 递归每个相邻节点
        for (int v : graph[i]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 i
        path.removeLast();
    }
}
