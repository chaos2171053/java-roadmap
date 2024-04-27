package org.example.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    //        这解法只适用于 nums 是升序
    //        int left = 0;
    //        int right = nums.length - 1;
    //        while(left<right){
    //            int sum = nums[left]+nums[right];
    //            if(sum == target){
    //                return new int[]{left, right};
    //            }else if (sum<target){
    //                left++;
    //            }else {
    //                right--;
    //            }
    //        }
    //        return new int[]{-1, -1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1, -1};
    }
}
