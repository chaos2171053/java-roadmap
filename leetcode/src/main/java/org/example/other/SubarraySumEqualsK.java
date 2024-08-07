package org.example.other;


import java.util.HashMap;
import java.util.Map;

//LCR 010. 和为 K 的子数组
//中等
//相关标签
//相关企业
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
//
//
//
//示例 1：
//
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
//示例 2：
//
//输入:nums = [1,2,3], k = 3
//输出: 2
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
//        int result = 0;
//        int sum = 0;
//        int i = 0;
//        while(i < nums.length){
//            if(nums[i]+sum<k){
//                sum = sum+nums[i];
//                i++;
//            }else if(nums[i]+sum==k){
//                result++;
//                sum=0;
//            }else {
//                sum=0;
//                i++;
//            }
//        }
//        return result;

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Initialize with prefix sum 0 count 1
        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            int complement = currentSum - k;
            if (prefixSumCount.containsKey(complement)) {
                count += prefixSumCount.get(complement);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
