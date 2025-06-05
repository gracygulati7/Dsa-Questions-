// https://leetcode.com/problems/next-permutation/

class Solution {
    public void nextPermutation(int[] nums) {
        // If the array is empty, just return
        if(nums.length == 0) return;

        // Initialize two indices to keep track of positions to swap
        int idx1 = -1, idx2 = -1;

        // Step 1: Find the first number from the end that is smaller than the number after it
        // This helps us find the point where the ascending order breaks
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                idx1 = i; // store the index
                break;
            }
        }

        // Step 2: If the entire array is in descending order (no such idx1), reverse it to lowest permutation
        if(idx1 < 0) {
            Arrays.sort(nums); // sort in ascending order
            return; // return after sorting so the rest of code stops working
        } else {
            // Step 3: Find the next bigger number from the right of idx1 to swap with
            for(int i = nums.length - 1; i >= 0; i--) {
                if(nums[i] > nums[idx1]) {
                    idx2 = i; // store the index
                    break;
                }
            }
        }

        // Step 4: Swap the two numbers found (idx1 and idx2)
        swap(nums, idx1, idx2);

        // Step 5: Sort the subarray from idx1+1 to end to get the next smallest permutation
        sortarr(nums, idx1 + 1, nums.length);
    }

    // Utility function to swap two elements in the array
    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    // Custom bubble sort function to sort the array from index 'st' to 'end-1' in ascending order
    public void sortarr(int[] nums, int st, int end) {
        for(int i = st; i < end; i++) {
            for(int j = st; j < end - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    // Swap if the current element is greater than the next
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
