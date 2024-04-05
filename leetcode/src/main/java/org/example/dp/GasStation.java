package org.example.dp;

//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // 相当于图像中的坐标点和最低点
        int sum = 0, minSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                // 经过第 i 个站点后，使 sum 到达新低
                // 所以站点 i + 1 就是最低点（起点）
                start = i + 1;
                minSum = sum;
            }
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 环形数组特性
        return start == n ? 0 : start;
    }

//    int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += gas[i] - cost[i];
//        }
//        if (sum < 0) {
//            // 总油量小于总的消耗，无解
//            return -1;
//        }
//        // 记录油箱中的油量
//        int tank = 0;
//        // 记录起点
//        int start = 0;
//        for (int i = 0; i < n; i++) {
//            tank += gas[i] - cost[i];
//            if (tank < 0) {
//                // 无法从 start 到达 i + 1
//                // 所以站点 i + 1 应该是起点
//                tank = 0;
//                start = i + 1;
//            }
//        }
//        return start == n ? 0 : start;
//    }
}
