package com.matos.medianoftwosortedarrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            // Partition in nums1
            int partitionA = (left + right) / 2;

            // Partition in nums2
            int partitionB = (m + n + 1) / 2 - partitionA;

            // Edge values around the partition in nums1
            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            // Edge values around the partition in nums2
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            // Check if partition is correct
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // If total length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    // If total length is odd
                    return Math.max(maxLeftA, maxLeftB);
                }
            }
            // Too far on the right for nums1, move left
            else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            }
            // Too far on the left for nums1, move right
            else {
                left = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {100, 200};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // 2.5
    }
}