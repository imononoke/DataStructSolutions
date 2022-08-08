package com.isa.hackerrank;

import java.math.BigDecimal;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true
 *
 * The factorial of the integer , written , is defined as:
 *
 * Calculate and print the factorial of a given integer.
 */
public class ExtraLongFactorials {
    public static void extraLongFactorials(int n) {
        // Write your code here
        System.out.println(calc(n));
    }

    private static BigDecimal calc(int n) {
        // long ret = 1; // long type would overflow the result

        BigDecimal result = new BigDecimal(1);
        // System.out.println("n: " + n);
        if (n <= 1)
            return result;

        // solution 1
        // BigDecimal tmp;
        // for(int i = 2; i <= n; i++) {
        //     tmp = new BigDecimal(i);
        //     result = result.multiply(tmp);
        // }

        // solution 2
        result = new BigDecimal(n).multiply(calc(n - 1));
        // System.out.println("result: " + result);
        return result;
    }
}
