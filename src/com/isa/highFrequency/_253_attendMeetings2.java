package com.isa.highFrequency;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/meeting-rooms-ii/
 */
public class _253_attendMeetings2 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // 按照开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 最小堆：store the end time of each meeting
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // start time of the No.i meeting is later than the top
            if (intervals[i][0] >= heap.peek()) { // could use the same room is the end time equals to the start time
                heap.remove();
            }
            heap.add(intervals[i][1]); // store the end time of the meeting
        }
        return heap.size();
    }
}
