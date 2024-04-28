package org.example.range;

import java.util.ArrayList;
import java.util.List;

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
//
//在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
//
//返回插入之后的 intervals。
//
//注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//示例 2：
//
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 创建一个列表来存储最终的合并区间
        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;
        int index = 0;

        // 将所有起始时间早于 newInterval 的区间加入 merged 列表
        while (index < n && intervals[index][1] < newInterval[0]) {
            merged.add(intervals[index++]);
        }

        // 合并与 newInterval 重叠的区间
        while (index < n && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        // 将合并后的 newInterval 加入 merged 列表
        merged.add(newInterval);

        // 将剩余的区间加入 merged 列表
        while (index < n) {
            merged.add(intervals[index++]);
        }

        // 转换为数组并返回
        return merged.toArray(new int[merged.size()][]);
    }
}
