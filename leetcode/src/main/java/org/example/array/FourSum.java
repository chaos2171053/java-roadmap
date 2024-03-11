package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> triples = threeSum(nums, i + 1,  target - nums[i]);
            for (List<Integer> triple : triples) {
                triple.add(0,nums[i]);
                result.add(triple);
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return result;

    }
    public List<List<Integer>> threeSum(int[] nums1,int start,int target) {
        Arrays.sort(nums1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums1.length; i++) {
            List<List<Integer>> tuples = twoSum(nums1, i + 1,  target - nums1[i]);
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
