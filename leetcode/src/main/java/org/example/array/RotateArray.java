package org.example.array;

//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
//
//
//示例 1:
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 确保 k 在数组长度范围内

        // 旋转整个数组
        reverse(nums, 0, nums.length - 1);

        // 旋转前 k 个元素
        reverse(nums, 0, k - 1);

        // 旋转剩余元素
        reverse(nums, k, nums.length - 1);
    }
    /**
     * 反转数组的指定部分
     *
     * @param nums  要反转的数组
     * @param start 反转开始的索引
     * @param end   反转结束的索引
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
