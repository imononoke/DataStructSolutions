package com.isa.hackerrank;

/**
 * Problem Statement – A stream of n data packets arrives at a server.
 * This server can only process packets that are exactly 2^n units long for some non-negative integer value of n (0<=n).
 *
 * All packets are repackaged in order to the 1 largest possible value of 2^n units.
 * The remaining portion of the packet is added to the next arriving packet before it is repackaged.
 * Find the size of the largest repackaged packet in the given stream.
 *
 * Returns:
 * Long : the size of the largest packet that is streamed
 *
 * Constraints :
 * 1<=n<=10^5
 * 1<=arriving Packets[i] size<=10^9
 */
public class _4_networkStream {

    public long maxStream(int[] streamArray) {
        if (streamArray == null) return 0;

        long max = 0;
        for (int i = 0; i < streamArray.length; i++) {

        }

        return max;
    }
}
