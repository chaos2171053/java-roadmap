package org.example.hashmap;

import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
//示例 1:
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//
//输入: strs = ["a"]
//输出: [["a"]]


//创建一个哈希表，键为字母异位词的排序后的字符串，值为对应的字母异位词列表。
//遍历字符串数组 strs，对于每个字符串，将其排序后的字符串作为键，将原始字符串添加到相应的值列表中。
//最后，将哈希表中的所有值列表组合成一个列表并返回。
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建哈希表，键为排序后的字符串，值为对应的字母异位词列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组，并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // 如果哈希表中不存在该键，则创建一个新的列表
            // 将原始字符串添加到对应的列表中
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        // 将哈希表中的所有值列表组合成一个列表并返回
        return new ArrayList<>(map.values());
    }
}
