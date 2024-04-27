package org.example.hashmap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false
public class IsAnagram {
    public Boolean isAnagram(String s, String t) {
//        if(s1==null || t1==null||s1.length()!=t1.length()){
//            return false;
//        }
//        HashMap<Character,Integer> hashMap = new HashMap<>();
//        int count = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            Character c = s1.charAt(i);
//            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
//            count++;
//        }
//        for (int i = 0; i < t1.length(); i++) {
//            Character c = t1.charAt(i);
//            if(hashMap.containsKey(c)&&count!=0&&hashMap.get(c)!=0){
//                hashMap.put(c,hashMap.getOrDefault(c,0)-1);
//                count--;
//            }
//        }
//        return count==0;
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false;
            }
            count[c - 'a']--;
        }

        return true;
    }
}
