package org.example.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals==null|| intervals.length ==0){
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = merged.get(merged.size()-1);
            if(curr[0] > last[1]) {
                merged.add(curr);
            }else {
                last[1] = Math.max(last[1], curr[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
