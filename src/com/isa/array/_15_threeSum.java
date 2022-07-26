package com.isa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,0,0,2,2};
        List<List<Integer>> list = threeSum(nums);
        System.out.print(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;

        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;

        Arrays.sort(nums);

        // i - scan the first int
        int lastR = nums.length - 1;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = lastR;
            int remains = -nums[i]; // remains + num[i] = 0

            while (l < r) {
                while (nums[l] == nums[l + 1]) l++;
                while (nums[r] == nums[r - 1]) r--;

                int sumLR = nums[l] + nums[r];
                if (sumLR == remains) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sumLR < remains) {
                    l++;
                } else { // sumLR > remains
                    r--;
                }
            }
        }
        return list;
    }
}
