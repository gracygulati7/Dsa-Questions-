// https://leetcode.com/problems/subarray-product-less-than-k/description/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // If k is 0 or 1, we can't form any subarray with product < k
        if (k <= 1) return 0;

        // We'll multiply numbers to get the product of subarrays
        int product = 1;

        // This will store our final answer (how many subarrays we found)
        int count = 0;

        // This is the start of the window (we'll move it when needed)
        int left = 0;

        // We loop over every number using 'right' as the end of the current subarray
        for (int right = 0; right < nums.length; right++) {
            // Multiply current number to our product
            product *= nums[right];

            // If the product becomes too large (≥ k), we shrink the window from the left
            while (product >= k) {
                // Divide the product by the number at the left (removing it from subarray)
                product /= nums[left];

                // Move left pointer to the right
                left++;
            }

            // At this point, product < k, so:
            // All subarrays from index 'left' to 'right' are valid
            // There are (right - left + 1) such subarrays
            count += right - left + 1;
        }
        return count;
    }
}
