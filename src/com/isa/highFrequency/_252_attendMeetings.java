package com.isa.highFrequency;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/meeting-rooms/
 */
public class _252_attendMeetings {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        // 按照开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        for (int i = 1; i < intervals.length; i++) {
            // if start time less than the end time of the former meeting, cannot attend the meeting -- false
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
