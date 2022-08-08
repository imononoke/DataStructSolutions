package com.isa.strings;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 *
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class _151_reverseWords {
    public String reverseWords(String s) {
        if (s == null) return null;
        String result = null;
        s = s.trim();
        char[] chars = s.toCharArray();
        // separate each word with blank

        boolean space = false; // char 前一个ch 是否是blank
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[index++] = chars[i];
                space = false;
            } else if (!space) { // current char is blank && the former char is not blank
                chars[index++] = ' ';
                space = true;
            }
        }
        // valid length of chars
        int len = space ? index - 1 : index;

        // reverse the whole string
        reverseString(chars, 0, len);
        System.out.println(chars);

        // reverse each word
        int prevSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ')
                continue;
            // char[i] is space now
            reverseString(chars, prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }
        // reverse the last word
        reverseString(chars, prevSpaceIdx + 1, len);
        System.out.println(chars);
        return new String(chars, 0, len);
    }

    private static void reverseString(char[] chars, int begin, int end) {
        end--;
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }
}
