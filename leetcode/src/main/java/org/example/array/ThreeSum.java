package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i],
// nums[j], nums[k]] 满足 i != j 、 i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums1) {
        Arrays.sort(nums1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            List<List<Integer>> tuples = twoSum(nums1, i + 1,  - nums1[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(0,nums1[i]);
                result.add(tuple);
            }
            while (i < nums1.length - 1 && nums1[i] == nums1[i + 1]) i++;

        }
        return result;
    }
    public  List<List<Integer>> twoSum(int[] nums,int start,int target) {
        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(right>left){
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum+rightNum;
            if(leftNum == target && rightNum == target){
                left++;
                right--;
            }else {
                if(target == sum){
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
                }else if(target>sum){
                    left++;
                }else {
                    right--;
                }
            }


        }
        return res;
    }
}
