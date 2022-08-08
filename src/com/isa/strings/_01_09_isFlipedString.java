package com.isa.strings;

/**
 * https://leetcode.cn/problems/string-rotation-lcci/
 */
public class _01_09_isFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        String s = s1 + s1;
        return (s1.length() == s2.length() && s.contains(s2));
    }
}
