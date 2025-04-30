// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store sum and its first index
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;        // total sum so far
        int maxlen = 0;     // longest subarray length found so far

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // add current element to sum

            // Case 1: If current sum equals k, entire subarray from 0 to i is valid.
            if (sum == k) {
                maxlen = i + 1;
            }

            // Case 2: If (sum - k) was seen before, a subarray with sum k exists
            if (map.containsKey(sum - k)) {
                // get the starting index of that subarray and calculate length
                int length = i - map.get(sum - k); // i is current index and map.get returns the starting index of subarray
                maxlen = Math.max(maxlen, length); // update max length if longer found
            }

            // Store the current sum in map only if it's not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
