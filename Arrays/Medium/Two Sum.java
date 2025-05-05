// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = 1; // Start with the first pair: left at 0, right just after it

        // Keep checking until 'left' reaches the second last index
        while (left < nums.length - 1) {
            int sum = nums[left] + nums[right]; // Calculate sum of current pair

            // If the current pair adds up to the target, return their indices
            if (sum == target) {
                return new int[] { left, right };
            }

            right++; // Move 'right' to the next index to check the next pair with same 'left'

            // If 'right' reaches nums.length, it means:
            // - We've already checked the last possible pair with this 'left'
            // - So, we must move 'left' one step forward
            // - And reset 'right' to be just after 'left' to check new pairs
            // We allow 'right' to become equal to nums.length (i.e., one step beyond the array)
            // to make sure we DO check the last element as part of a pair before resetting.
            if (right == nums.length) {
                left++;           // Move 'left' forward
                right = left + 1; // Reset 'right' to next index after 'left'
            }
        }

        // If no pair is found that adds up to the target, return null
        return null;
    }
}
