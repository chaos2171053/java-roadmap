package org.example.array;


//给你一个 非严格递增排列 的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。
// 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
//
//考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//
//更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
// nums 的其余元素与 nums 的大小不重要。
//返回 k 。
//判题标准:
//
//系统会用下面的代码来测试你的题解:
//
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//assert nums[i] == expectedNums[i];
//}
//如果所有断言都通过，那么您的题解将被 通过。
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // 处理空数组的情况
        int slow = 0; // 慢指针，指向当前处理的位置
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                // 如果当前元素与慢指针指向的元素不相同，则将当前元素复制到慢指针的下一个位置
                // 并且将慢指针向后移动一位
                slow++;
                nums[slow] = nums[fast];
            }
            // 如果当前元素与慢指针指向的元素相同，则继续向后移动快指针，直到找到不同的元素
        }
        // 返回慢指针位置作为新数组的长度
        return slow + 1;
    }
}
