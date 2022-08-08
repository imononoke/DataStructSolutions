package com.isa.strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/valid-anagram/
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class _242_isAnagram {

    public boolean isAnagram(String s, String t) {
        // hashmap record the chars number -- not recommanded
        // use a table to store the 26 alphabets, each number means the times of each alpha

        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();

        int[] table = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            table[chars1[i] - 'a']++;
        }

        for (int j = 0; j < chars2.length; j++) {
            if (table[chars2[j] - 'a'] - 1 < 0)
                return false;
        }
        return true;
    }
}
