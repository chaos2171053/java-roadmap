package org.example.array;

import java.util.HashMap;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//注意：
//
//对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。
public class MinimumWindowSubstring {
    // 暴力解法
//    public String minWindow(String s, String t) {
//        if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
//            return "";
//        }
//
//        int minLen = Integer.MAX_VALUE;
//        String minWindow = "";
//
//        // 遍历 s 中的所有可能的子串
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + t.length(); j <= s.length(); j++) {
//                String sub = s.substring(i, j);
//                // 检查子串是否包含了 t 中的所有字符
//                if (containsAllCharacters(sub, t)) {
//                    // 更新最小覆盖子串的起始位置和长度
//                    if (j - i < minLen) {
//                        minLen = j - i;
//                        minWindow = sub;
//                    }
//                }
//            }
//        }
//
//        return minWindow;
//    }
//
//    // 检查字符串 s 是否包含字符串 t 中的所有字符
//    private boolean containsAllCharacters(String s, String t) {
//        int[] countS = new int[256];
//        int[] countT = new int[256];
//
//        for (char c : t.toCharArray()) {
//            countT[c]++;
//        }
//
//        for (char c : s.toCharArray()) {
//            countS[c]++;
//        }
//
//        for (int i = 0; i < 256; i++) {
//            if (countT[i] > 0 && countS[i] < countT[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
