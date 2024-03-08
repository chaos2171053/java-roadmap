package org.example.array;
//给你一个字符串 s，找到 s 中最长的回文子串。
//
//如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//回到最长回文串的问题，解法的大致思路就是：
//        for 0 <= i < len(s):
//          找到以 s[i] 为中心的回文串
//          找到以 s[i] 和 s[i+1] 为中心的回文串
//          更新答案
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s1) {
        String res  = "";
        for (int i = 0; i < s1.length(); i++) {
            String s2 = palindrome(s1,i,i);
            String s3 = palindrome(s1,i,i+1);
            res = res.length() > s2.length() ? res : s2;
            res = res.length() > s3.length() ? res : s3;
        }

        return res;
    }
    public String palindrome(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
