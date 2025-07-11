package com.dsa.showcase.array.unionandintersection;

import java.util.HashSet;
import java.util.Set;
/*349. Intersection of Two Arrays
Solved
        Easy
Topics
conpanies icon
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



        Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


        Constraints:

        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000*/
class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Always iterate over smaller array for efficiency
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> smallSet = new HashSet<>();
        for (int num : nums1) {
            smallSet.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (smallSet.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
}
