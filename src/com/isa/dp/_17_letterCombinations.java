package com.isa.dp;

import java.util.ArrayList;
import java.util.List;

public class _17_letterCombinations {

    private static char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };

    private static char[] chars;
    private static char[] eachLineChars;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        List<String> res = letterCombinations("57");
        System.out.println(res);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null) return null;

        chars = digits.toCharArray();
        if (chars.length == 0) return list;
        eachLineChars = new char[chars.length];
        dfs(0);
        return list;
    }

    /**
     * search the idx level
     * @param idx
     */
    private static void dfs(int idx) {
        // 先写最后退出的条件
        if (idx == chars.length) {
            // get result
            list.add(new String(eachLineChars));
            return;
        }

        // for 枚举这一层能做的选择
        char[] letters = lettersArray[chars[idx] - '2'];
        for (char letter : letters) {
            eachLineChars[idx] = letter;
            dfs(idx + 1);
        }
    }
}
