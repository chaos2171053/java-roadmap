package org.example.dp;


//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组
//是数组中的一个连续部分。
public class MaximumSubarray {
    public static Object maxSubArray(int[] nums) {
//        int left = 0;
//        int right = 0;
//        int windowSum = 0, maxSum = Integer.MIN_VALUE;
//        while(right<nums.length){
//            windowSum+=nums[right];
//            right++;
//            maxSum = windowSum > maxSum ? windowSum : maxSum;
//            while (windowSum<0){
//                windowSum -=  nums[left];
//                left++;
//            }
//        }
//        return maxSum;


//        int n = nums.length;
//        if (n == 0) return 0;
//        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
//        int[] dp = new int[n];
//        // base case
//        // 第一个元素前面没有子数组
//        dp[0] = nums[0];
//        // 状态转移方程
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
//        }
//        // 得到 nums 的最大子数组
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;

        int n = nums.length;
        if (n == 0) return 0;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < n; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i-1])
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大的结果
            res = Math.max(res, dp_1);
        }

        return res;
    }
}
