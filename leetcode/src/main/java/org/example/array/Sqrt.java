package org.example.array;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。


public class Sqrt {
    public int mySqrt(int x) {
        if(x==0||x==1){
            return x;
        }
        long left = 1;
        long right = x;
        while(left<=right){
            long mid = left + (right-left)/2;
            long square = mid * mid;
            if(square == x){
                return (int) mid;
            }else if(square>x){
                right = mid - 1;
            }else {
                left = mid+1;
            }
        }
        // 返回右边界值，因为右边界值的平方是小于或等于x的最大整数
        return (int) right;

    }
}
