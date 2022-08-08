package com.isa.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/countingsort4/problem?isFullScreen=true
 *
 * Use the counting sort to order a list of strings associated with integers.
 * If two strings are associated with the same integer, they must be printed in their original order,
 * i.e. your sorting algorithm should be stable.
 * There is one other twist: strings in the first half of the array are to be replaced with the character - (dash, ascii 45 decimal).
 *
 * 给出一串(整数,字符串)序列，要求根据整数的大小排序这些元组，然后把开始位于数组后半部分的单词按照排序后的单词输出，位于前半部分的单词则用“-”代替。
 */
public class CountingSort4 {

    // Driver code
    public static void main(String args[]) {
        List<List<String>> list = new ArrayList<>();
        List<String> sub1 = new ArrayList<>();
        List<String> sub2 = new ArrayList<>();
        List<String> sub3 = new ArrayList<>();
        List<String> sub4 = new ArrayList<>();
        List<String> sub5 = new ArrayList<>();
        sub1.add("1");
        sub1.add("e");
        sub2.add("2");
        sub2.add("a");
        sub3.add("1");
        sub3.add("b");
        sub4.add("3");
        sub4.add("a");
        sub5.add("1");
        sub5.add("f");
        list.add(sub1);
        list.add(sub2);
        list.add(sub3);
        list.add(sub4);
        list.add(sub5);

//        CountingSort cs = new CountingSort();
        countSort(list);
    }

    // ref:
//    def countSort(arr):
//    count = [[] for _ in range(100)]
//    mid = int(len(arr)/2)
//
//            for index in range(len(arr)):
//            if index < mid:
//    arr[index][1] = '-'
//    count[arr[index][0]].extend(arr[index][1])


    // Counting sort in Java programming

    static void countSort(List<List<String>> arr) {
        int size = arr.size();
        StringBuilder[] freqs = new StringBuilder[100];
        HashMap<Integer, List<String>> map = new HashMap<>(); // key: index, value: strings of the same index

        for (int i = 0; i < size; i++) {
            List<String> list = arr.get(i);
            String idx = list.get(0);
            String word = list.get(1);
            // int idx = scanner.nextInt();

            Integer key = Integer.parseInt(idx);
            if (!map.containsKey(key)) { // original: [1, "a"], new one: [1, "b"]
                List<String> subList = new ArrayList<>();
                subList.add(word);
                map.put(key, subList);
            } else { // contains the index
                List<String> tmp = map.get(key);
                tmp.add(word);
                map.put(key, tmp);
                String[] strArr = new String[tmp.size()];
                tmp.toArray(strArr);
                Arrays.sort(strArr);
            }

//            if (i < size / 2) {
//                freqs[i] = freqs[i] == null ?
//                        new StringBuilder("-") : freqs[i].append(" -");
//                // scanner.next();
//            } else {
//
//                freqs[i] = freqs[i] == null ? new StringBuilder(word) : freqs[i].append(" ").append(word);
//            }
        }

        for (int i = 0; i < map.size(); i++) {
            List<String> words = map.get(i);
            for (int j = 0; j < words.size(); j++) {
                String lastWord = words.get(j);
                int idx = i * map.size() + j;
                if (j != words.size() - 1) {
                    freqs[idx] = freqs[idx] == null ? new StringBuilder("-") : freqs[idx].append(" -");
                } else {
                    freqs[idx] = freqs[idx] == null ? new StringBuilder(lastWord) : freqs[idx].append(" ").append(lastWord);
                }
            }
        }

        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] != null) {
                System.out.print(freqs[i].toString());
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
