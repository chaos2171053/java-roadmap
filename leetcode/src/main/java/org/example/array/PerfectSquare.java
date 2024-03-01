package org.example.array;

//给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
//完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
//
//不能使用任何内置的库函数，如  sqrt 。
public class PerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num ==1 || num ==0){
            return true;
        }
        long left = 1;
        long right = num;
        while(left<=right){
            long mid = left + (right-left)/2;
            long square = mid * mid;
            if(square == num){
                return true;
            }else if(square>num){
                right = mid - 1;
            }else {
                left = mid+1;
            }
        }
        // 返回右边界值，因为右边界值的平方是小于或等于x的最大整数
        return false;
    }
}
