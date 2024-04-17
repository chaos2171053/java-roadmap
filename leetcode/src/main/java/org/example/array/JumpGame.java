package org.example.array;


//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
//
//
//
//示例 1：
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置超过了最远可达距离，返回false
            if (i > maxReach) {
                return false;
            }
            // 更新最远可达距离
            maxReach = Math.max(maxReach, i + nums[i]);
            // 如果最远可达距离已经超过或等于数组的最后一个位置，返回true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
