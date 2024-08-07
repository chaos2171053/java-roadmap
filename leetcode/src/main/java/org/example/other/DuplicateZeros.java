package org.example.other;


//给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
//注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
//
//
//
//示例 1：
//
//输入：arr = [1,0,2,3,0,4,5,0]
//输出：[1,0,0,2,3,0,0,4]
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//示例 2：
//
//输入：arr = [1,2,3]
//输出：[1,2,3]
//解释：调用函数后，输入的数组将被修改为：[1,2,3]

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0;
        while(i<n){
            if(arr[i]==0){
                for (int j = n-1; j >i; j--) {
                    arr[j] = arr[j-1];
                }
                if(i+1<n){
                    arr[i+1]=0;
                }
                i+=2;
            }else{
                i++;
            }

        }
    }
}
