package org.example.array;

// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 解法1 ：暴力解法，时间复杂度 O(n^2)，空间复杂度 O(1)
//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
//                for (int j = i + 1; j < size; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
//                size--; // 此时数组的大小-1
//            }
//
//        }
//        return size;

        // 解法2:双指针. 快慢双指针。
//        int slowIndex = 0;
//        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
//            if(nums[fastIndex]!=val){
//                nums[slowIndex++] = nums[fastIndex];
//                //slowIndex++;
//            }
//        }
//        System.out.println("===nums===: "+ Arrays.toString(nums));
//        return slowIndex;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            // 找左边等于val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val){
                ++leftIndex;
            }
            // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                -- rightIndex;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        // leftIndex一定指向了最终数组末尾的下一个元素
        return leftIndex;
    }
}
