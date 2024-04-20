package org.example.array;

//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//
//
//示例 1:
//
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
//示例 2:
//
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
//        int[]result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int total = 1;
//            int index = i-1;
//            while(index>=0){
//                total = total * nums[index--];
//            }
//            index = i+1;
//            while(index<nums.length){
//                total = total * nums[index++];
//            }
//            result[i] = total;
//        }
//        return result;
//        int[]result = new int[nums.length];
//        for (int i = 0, len = nums.length; i < len; i++) {
//            int total = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    total = total * nums[j];
//                }
//
//            }
//            result[i]= total;
//        }
//        return result;

        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[]answer = new int[length];
        L[0] = 1;
        for (int i = 1; i <length; i++) {
            L[i] = L[i-1] * nums[i - 1];
        }
        R[length-1]=1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
}
