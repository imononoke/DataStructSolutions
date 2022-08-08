package com.isa.strings;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class _3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        char ch;
        int longestLength = 0;

        for (int i = 0, start = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, i + 1);
            longestLength = Math.max(longestLength, i - start + 1);
        }
        return longestLength;
    }
}
