package org.example.binary;


//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
//
//
//
//示例 1：
//
//输入:a = "11", b = "1"
//输出："100"
//示例 2：
//
//输入：a = "1010", b = "1011"
//输出："10101"

public class BinaryAdder {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0||j>=0){
            int sum = carry;
            if(i>=0){
                sum += a.charAt(i--) - '0';
            }
            if(j>=0){
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}
