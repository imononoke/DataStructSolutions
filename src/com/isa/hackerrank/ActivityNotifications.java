package com.isa.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 *
 * Given the number of trailing days d and a client's total daily expenditures for a period of n days,
 * determine the number of times the client will receive a notification over all n days.
 *
 * 0 <= expenditure[i] <= 200
 */
public class ActivityNotifications {
    public static void main(String[] args) {
        List<Integer> exp = new ArrayList<>();
        exp.add(10);
        exp.add(20);
        exp.add(30);
        exp.add(40);
        exp.add(50);
        int ret = activityNotifications(exp, 3);
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int start = 0, mid1, mid2, count=0;
        float median;
        mid2 = d/2 + 1;

        if(d % 2 == 0)
            mid1 = mid2 - 1;
        else
            mid1 = mid2;
        System.out.println("mid1= "+mid1+" mid2= "+ mid2);
        int[] countArr = new int[201];

        for(int i = 0; i < d; i++) {
            ++countArr[expenditure.get(i)];
        }

        for(int i = d; i < expenditure.size(); i++) {
            median = findMedian(countArr, mid1, mid2);
            System.out.print(" median= "+ median);
            if(expenditure.get(i) >= median * 2)
                count++;
            --countArr[expenditure.get(start)];
            start++;
            ++countArr[expenditure.get(i)];
        }

        return count;
    }

    static public float findMedian(int[] arr, int mid1, int mid2) {
        int count = 0, temp1 = 0, temp2 = 0, i = 0;
        while(count < mid1) {
//            System.out.println("arr[i]= "+ )
            count += arr[i];
            i++;
        }
        //       System.out.print("arr[i]="+arr[i]+ " i= "+i);
        System.out.print(" count= "+ count+" i= "+ i);
        temp1 = i - 1;
        while(count < mid2) {
            count += arr[i];
            i++;
        }
        temp2 = i-1;
        //      System.out.println(" i= "+i);
        //   System.out.print("arr[10] = "+ arr[10]);
        return (temp1+temp2) / (float)2.0;
    }
}
