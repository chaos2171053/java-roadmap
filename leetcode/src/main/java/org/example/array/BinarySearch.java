package org.example.array;

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
//写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
public class BinarySearch {
    public int search(int[] nums, int target) {
//        int left = 0;
//        int length = nums.length;
//        while(left<length){
//            int mid = (left + length )/2;
//            if(nums[mid]==target){
//                return mid;
//            } else if (nums[mid]>target) {
//                left = mid + 1;
//            }else {
//                left = mid - 1;
//            }
//        }

        int left = 0;
        int right = nums.length - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值，直接返回下标
            }
        }

        return -1;
    }
}
