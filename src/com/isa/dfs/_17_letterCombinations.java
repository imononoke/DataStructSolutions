package com.isa.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 */
public class _17_letterCombinations {

    public static void main(String[] args) {
        letterCombinations("24");
    }

    private static char[][] lettersArray = new char[][] {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, //  2，3
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, // 4， 5， 6
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}, // 7，8，9
    };

    private static List<String> res;
    private static char[] chars;
    // store string of each line
    private static char[] lineString;

    public static List<String> letterCombinations(String digits) { // "23"
        if (digits == null) return null;

        res = new ArrayList<>();
        chars = digits.toCharArray();
        if (chars.length == 0) return res; // "" -> should return []

        lineString = new char[chars.length];
        dfs(0);
        return res;
    }

    // search the idx layer
    private static void dfs(int idx) {
        if (idx == chars.length) {
            // have been the bottom layer and get a result here
            res.add(new String(lineString));
            return;
        }

        // search this layer first
        char[] letters = lettersArray[chars[idx] - '2']; // because the letters table start from '2'
        for (char letter : letters) {
            lineString[idx] = letter;
            // go to the next layer
            dfs(idx + 1);
        }
    }
}
