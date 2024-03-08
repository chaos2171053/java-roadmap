package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//如果假设输入一个数组 nums 和一个目标和 target，
// 请你返回 nums 中能够凑出 target 的两个元素的值，
// 比如输入 nums = [1,3,5,6], target = 9，那么算法返回两个元素 [3,6]。
public class TwoSum {
    public List<List<Integer>> twoSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while (left<right){
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum+rightNum;
            if(sum==target){
                List<Integer> pair = new ArrayList<>();
                pair.add(leftNum);
                pair.add(rightNum);
                res.add(pair);
                // 跳过所有重复的元素
                while(nums[right]==rightNum && right>left){
                    right--;
                }
                while(nums[left]==leftNum && left<right){
                    left++;
                }
            }else if(sum>target){
                right--;
            }else {
                left++;
            }

        }
        return  res;
    }
}
