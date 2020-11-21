package com.minos.leetcode.SortColor_75;

/**
 * @Author: minos
 * @Date: 2020/11/21 14:51
 */
class Solution {

    public void sortColors(int[] nums) {

        // 循环不变量 nums[0, zero] == 0, nums[zero + 1, i - 1] == 1, nums[two, n - 1] == 2
        int zero = -1, i = 0, two = nums.length;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else { // nums[i] == 1
                i++;
            }
        }

    }

    private void swap(int[] nums, int l, int p) {
        int t = nums[l];
        nums[l] = nums[p];
        nums[p] = t;
    }
}
