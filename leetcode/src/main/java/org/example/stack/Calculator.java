package org.example.stack;

import java.util.Stack;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
//
//
//
//示例 1：
//
//输入：s = "1 + 1"
//输出：2
//示例 2：
//
//输入：s = " 2-1 + 2 "
//输出：3
//示例 3：
//
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
public class Calculator {
    public Object calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0;
        int sign = 1; // 1 represents '+', -1 represents '-'

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * operand;
                operand = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * operand;
                operand = 0;
                result *= stack.pop(); // pop sign
                result += stack.pop(); // pop result outside of parenthesis
            }
        }

        return result + (sign * operand);
    }
}
