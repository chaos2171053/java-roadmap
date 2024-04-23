package org.example.hashmap;


//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
//这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
//
//
//
//示例1:
//
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true
//示例 2:
//
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false
//示例 3:
//
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map1.containsKey(ch) && !map1.get(ch).equals(word)) {
                return false;
            }

            if (map2.containsKey(word) && map2.get(word) != ch) {
                return false;
            }

            map1.put(ch, word);
            map2.put(word, ch);
        }

        return true;
    }
}
