package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;



//77. 组合
//        中等
//        相关标签
//        相关企业
//        给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//        你可以按 任何顺序 返回答案。
//
//
//
//        示例 1：
//
//        输入：n = 4, k = 2
//        输出：
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
//        示例 2：
//
//        输入：n = 1, k = 1
//        输出：[[1]]
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(result, current, n, k, i + 1);
            current.remove(current.size() - 1);
        }
    }

}
