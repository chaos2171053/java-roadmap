package org.example.tree;

public class MergeSort {
    // 辅助合并数组
    private static int[] temp;

    public static void mergeSort(int[] arr) {
        temp = new int[arr.length];
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }
        int mid = low + (high-low)/2;
        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr,int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i]=arr[i];
        }
        // 利用数组双指针，合并两个有序数组
        int i  = low;
        int j = mid+1;
        for (int p = low; p <= high; p++) {
            if(i==mid+1){
                // 左边数组已经合并
                arr[p] = temp[j++];
            }else if (j == high + 1) {
                // 右半边数组已全部被合并
                arr[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                arr[p] = temp[j++];
            } else {
                arr[p] = temp[i++];
            }
        }
    }
}
