package com.alibaba.cainiao;

import com.alibaba.cainiao.leetcode.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] q = {10,20,5};
        int[] w = {70,50,30};

        LeetCode7 leetCode = new LeetCode7();
        leetCode.reverse(123);
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i < j) {
                swap(nums, i, j);
            }
        }

        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}