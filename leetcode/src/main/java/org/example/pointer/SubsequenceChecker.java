package org.example.pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//进阶：
//
//如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//
//
//
//示例 1：
//
//输入：s = "abc", t = "ahbgdc"
//输出：true
//示例 2：
//
//输入：s = "axc", t = "ahbgdc"
//输出：false
public class SubsequenceChecker {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> charIndexMap = new HashMap<>();

        // 构建 t 中字符到其索引的映射
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charIndexMap.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int prevIndex = -1;
        for (char c : s.toCharArray()) {
            if (!charIndexMap.containsKey(c)) {
                return false; // s 中的字符在 t 中不存在
            }

            List<Integer> indices = charIndexMap.get(c);
            int index = binarySearch(indices, prevIndex);

            if (index == -1) {
                return false; // s 中的字符在 t 中的索引小于 prevIndex
            }

            prevIndex = indices.get(index);
        }

        return true;
    }
    // 使用二分查找找到大于 prevIndex 的最小索引
    private int binarySearch(List<Integer> indices, int target) {
        int left = 0, right = indices.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (indices.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < indices.size() ? left : -1;
    }
}
