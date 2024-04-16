package org.example.array;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
public class ArrayDuplicateRemover {
    public int removeDuplicatesWithLimit(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2; // 慢指针从索引2开始，因为我们允许每个元素最多出现两次
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
