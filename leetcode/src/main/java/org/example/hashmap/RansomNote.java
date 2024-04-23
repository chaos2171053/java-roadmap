package org.example.hashmap;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
//示例 1：
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//示例 2：
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//示例 3：
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
public class RansomNote {
    public boolean canConstruct(String ransomNoteStr, String magazineStr) {
        int[] count = new int[26];

        // Count characters in magazine
        for (char ch : magazineStr.toCharArray()) {
            count[ch - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char ch : ransomNoteStr.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }

        return true;
    }
}
