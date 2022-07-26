package com.isa.dp

fun longestPalindrome(s: String) : String {
    val chars = s.toCharArray()
    val len = chars.size
    if (chars.size <= 1) return s

    var maxLen = 0
    var beginIdx = 0

    val dp = Array(len + 1) { BooleanArray(len + 1) }
    dp[0][0] = true

    for (i in len - 1 downTo 0) {
        for (j in i until len) {
            val dpLen = j - i + 1
            dp[i][j] = (chars[i] == chars[j]) &&
                    (dpLen <= 2 || dp[i + 1][j - 1])
            if (dp[i][j] && (dpLen > maxLen)) {
                maxLen = dpLen
                beginIdx = i
            }
        }
    }
    return s.substring(beginIdx, beginIdx + maxLen)
}
