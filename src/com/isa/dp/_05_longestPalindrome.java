package com.isa.dp;

public class _05_longestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        String res = longestPalindromeCenterExtend3(s);
//        String res = longestPalindromeFromCenterEx(s);
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        if (s == null) return null;

        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) return "";
        // 除去"", 最小长度为1
        int maxLen = 1;

        // dp[][] save `true` or `false`
        boolean[][] dp = new boolean[len][len];
        int beginIdx = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                int length = j - i + 1;
                // 当前 str 是否为回文串
                // === char i 和 j 是否相等 && (当前str长度 <= 2 || i后一位字符到j前一位字符的str也是回文串)
                dp[i][j] = (chars[i] == chars[j])
                        && (j - i <= 1 || dp[i + 1][j - 1]);
                if (dp[i][j] && length > maxLen) { // if true, current str is palindrome
                    maxLen = length;
                    beginIdx = i;
                }
            }
        }
        return s.substring(beginIdx, beginIdx + maxLen);
    }

    // 中心扩展法: 由连续的相同字符组成的子串作为扩展中心
    public static String longestPalindromeFromCenter(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 未包含 len == 1 的情况，chars[1] is out of bounds，所以 len 为 1 的情况也需要提前过滤。
//        if (len == 0) return s;
        if (len <= 1) return s;
        // 除去"", 最小长度为1
        int maxLen = 1;
        int beginIdx = 0;

        // i start from len - 2
        for (int i = len - 2; i >= 1; i--) {
            // 以 i 为中心（以 char 为中心得到的回文串长度是奇数）
            int len1 = getPalindromeLength(chars, i - 1, i + 1);
            // 以 i 和 i + 1 的边界为中心（以 char 边界为中心得到的回文串长度是偶数）
            int len2 = getPalindromeLength(chars, i, i + 1);

            int length = Math.max(len1, len2);
            if (length > maxLen) {
                maxLen = length;
//                beginIdx = i - maxLen / 2; // 不适用与间隔为中心的情况
                beginIdx = i - ((maxLen - 1) >> 1);
            }
        }
        // 单独处理 char[0]
        if (chars[0] == chars[1] && maxLen == 1) {
            maxLen = 2;
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    public static int getPalindromeLength(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
//        return right - left + 1; // wrong
        return right - left - 1; // left and right may be out of range now
    }

    public static String longestPalindromeFromCenterEx(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len <= 1) return s;
        // 除去"", 最小长度为1
        int maxLen = 1;
        int beginIdx = 0;

        int i = 0;
        while (i < len) {
            // save left index first
            int left = i - 1;

            // find the first item which is not equal to char[i]
            int right = i;
            while (++right < len && chars[i] == chars[right]);
            i = right;

            while (left >= 0 && right < len && chars[left] == chars[right]) {
                left--;
                right++;
            }

            // chars[left] != char[right] or left / right is out of range
            // str range: [left + 1, right - 1]
            int length = right - ++left; // length = right - left - 1
            if (length > maxLen) {
                maxLen = length;
                beginIdx = left;
            }
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    // Write again

    // solution1 - using dp
    public static String longestPalindrome1(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        // 长度为 0 / 1 的情况都先过滤
        if (chars.length <= 1)
            return s;

        int maxLen = 1;
        int beginIdx = 0;
        int len = chars.length;
        // dp: save values of whether the str is palindrome - true or false
        boolean[][] dp = new boolean[len][len];

        // find dp[i][j] formula
        // if length == 2, char[0] == chars[1] -> palindrome str
        // if length > 2, dp[i + 1][j - 1] is palindrome str && char[i] == char[j] -> palindrome str
        // when i <= j, the str is valid; if i > j, the str is invalid.
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (chars[i] == chars[j]) && (
                        // chars.length <= 2 || // wrong!
                        j - i <= 1 || // if the length is equal to 2
                        dp[i + 1][j - 1]); // dp[i + 1][j - 1] is palindrome
                int length = j - i + 1;
                // if dp[i][j] is palindrome
                if (dp[i][j] && length > maxLen) {
                    maxLen = length;
                    beginIdx = i;
                }
            }
        }
        return s.substring(beginIdx, beginIdx + maxLen);
    }

    // extend from center
    public static String longestPalindromeCenterExtend2(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        // 长度为 0 / 1 的情况都先过滤
        if (chars.length <= 1)
            return s;

        int maxLen = 1;
        int beginIdx = 0;
        int len = chars.length;

        // 以每个 char or 间隔为中心扩散，i starts from the second last one && bigger than `1`
        for (int i = len - 2; i >= 1; i--) {
            // char range: i - 1, i + 1
            int lenChar = getPalindromeLength2(chars, i - 1, i + 1);
            // divider range: i, i + 1
            int lenDivider = getPalindromeLength2(chars, i, i + 1);
            int length = Math.max(lenChar, lenDivider);
            if (length > maxLen) {
                maxLen = length;
                // 如果中心 i 是 char，begin index 是 i - length 的一半
                // 如果中心 i 与 i + 1 之间的 divider，length / 2 就不正确
//                beginIdx = i - (maxLen - 1) >> 1; // wrong! +/-/位运算同时有，>> 要加()
                beginIdx = i - ((maxLen - 1) >> 1);
            }
        }

        // handle char[0]
        if (chars[0] == chars[1] && maxLen == 1) {
            maxLen = 2;
            // begin index is still 0
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    private static int getPalindromeLength2(char[] chars, int left, int right) {
        while (left >= 0 &&
                right < chars.length &&
                chars[left] == chars[right]
        ) {
            left--; // left would decrease
            right++; // right would increase
        }
        return right - left - 1;
    }

    // extend from center optimize
    // 由连续的相同字符组成的子串作为扩展中心
    public static String longestPalindromeCenterExtend3(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        // 长度为 0 / 1 的情况都先过滤
        if (chars.length <= 1)
            return s;

        int maxLen = 1;
        int beginIdx = 0;
        int len = chars.length;

        // 找到右边第一个不等于 s[i] 的 char，index: right，right作为下次开始查找的 i。
//        for (int i = 0; i < len; i++) { // wong!!
        int i = 0;
        while (i < len) {
//            int left = i; // wrong!
            int left = i - 1; // left is left to `i`
            int right = i;
            // right initialized == i, so right increase 1 first
            while (++right < len && chars[i] == chars[right]);
            i = right; // save the right position as next start index

            // 以 left & right 包含的 subStr 作为扩展中心
            while (left >= 0 && right < len &&
                    chars[left] == chars[right]
            ) {
                left--;
                right++;
            }
            // now left or right may be out of bound
            // 此时回文 subStr 范围：(left, right) == [left + 1, right - 1], left should be increase 1 for convenience
            int length = right - ++left; // equals to `right - left - 1`
            if (length > maxLen) {
                maxLen = length;
//                beginIdx = i - ((maxLen - 1) >> 1); // wrong!
                beginIdx = left; // begin index should be left (after increased)
            }
        }

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    public static String longestPalindromeManacher(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        // 长度为 0 / 1 的情况都先过滤
        if (chars.length <= 1)
            return s;

        int maxLen = 1;
        int beginIdx = 0;

        return s.substring(beginIdx, beginIdx + maxLen);
    }

    private static char[] preprocess(char[] ori) {
        int len = ori.length;
        char[] chars = new char[(len >> 1) + 3];

        return chars;
    }


    // review Apr.10
    public static String longestPalindromeDp(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (chars.length <= 1) return s;

        int maxLen = 0;
        int beginIdx = 0;
        boolean[][] dp = new boolean[len][len];

        dp[0][0] = true;
        // if len (j - i + 1) == 2, dp[i] == dp[j]
        // if len > 2, dp[i] == dp[j] && dp[i][j] === dp[i + 1][j - 1] is palindrome
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (dp[i] == dp[j]) && (j - i == 1 || dp[i + 1][j - 1]);
                int dpLen = j - i + 1;
                if (dp[i][j] && (dpLen > maxLen)) {
                    maxLen = dpLen;
                    beginIdx = i;
                }
            }
        }
        return s.substring(beginIdx, beginIdx + maxLen);
    }

    public String longestPalidromeDp2(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s; // "" or length == 1

        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int startIdx = 0;

        // dp[i][j] 表示坐标 [i, j] 位置的字符串是否为回文
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (chars[i] == chars[j])
                        && (j - i == 1 || dp[i - 1][j + 1]); // length == 2 or 前后各减一个字符也是回文
                int dpLen = j - i + 1;
                if (dp[i][j] && (dpLen > maxLen)) { // dp[i][j] is true && 当前回文串长度大于 maxLen
                    maxLen = dpLen; // update max len
                    startIdx = i;
                }
            }
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
}
