package org.example.pointer;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        // 清理字符串，只保留字母和数字，并转换为小写
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 使用两个指针从字符串的两端向中间移动，逐个比较字符
        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false; // 如果字符不匹配，则不是回文串
            }
            left++;
            right--;
        }

        return true; // 所有字符都匹配，是回文串

    }
}
