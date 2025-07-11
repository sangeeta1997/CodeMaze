package com.dsa.showcase.array.kadane;
/*918. Maximum Sum Circular Subarray
Solved
        Medium
Topics
        Companies
Hint
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



        Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.


Constraints:

n == nums.length
1 <= n <= 3 * 104
        -3 * 104 <= nums[i] <= 3 * 104*/
class MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int currentMax=0;
        int max=nums[0];
        int currentMin=0;
        int min=nums[0];
        int total=0;
        for(int num: nums){
            currentMax=Math.max(currentMax+num,num);
            max=Math.max(max,currentMax);
            currentMin=Math.min(currentMin+num,num);
            min=Math.min(min,currentMin);
            total+=num;
        }
        if(min==total){
            return max;  //no circular i greator than max
        }
        return Math.max(max,total-min);
    }
}