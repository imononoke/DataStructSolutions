package com.isa.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AutoCorrect {
    public static void main(String[] args) {
        String[] list = new String[] {"abc", "abcde", "bvde", "bcdf", "edaz", "acby"};
        List<String> res = autoCorrect("abcd", list);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> autoCorrect(String input, String[] strList) {
        if (input == null || input.length() == 0 || strList == null || strList.length == 0) return null;
        char[] inputChars = input.toCharArray();
        HashSet<Character> m = new HashSet<>();
        int inputLen = input.length();
        int strListLen = strList.length;
        List<String> result = new ArrayList<>();
        for (int i =0; i< input.length(); i++) {
            Character c = input.charAt(i);
            m.add(c);
        }
        int minCount = strListLen;
        for (String s : strList) {
            int count = 0;
            String str = s;
            if (str.length() != inputLen) continue;
            for (int j = 0; j < str.length(); j++) {
                char listc = str.charAt(j);
                if (!m.contains(listc)) {
                    count++;
                }
            }
            if (count < minCount) {
                minCount = count;
                result = new ArrayList<>();
                result.add("min count is：" + minCount + " " + str);
            } else if (count == minCount) {
                result.add("min count is：" + minCount + " " + str);
            }
        }
        return result;
    }

    public static List<String> autoCorrectSuggestions(String input, List<String> destinations) {
        List<String> list = new ArrayList<>();
        if (input == null || destinations == null) return list;

        for (int i = 0; i < destinations.size(); i++) {
            if (destinations.get(i).length() != input.length())
                continue;
        }

        return list;
    }
}
