// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        // Step 1: Sort both arrival and departure times
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Step 2: Initialize pointers and counters
        int n = arr.length;
        int platforms = 0;       // Current platforms needed
        int maxPlatforms = 0;    // Result: max platforms needed at any time

        int i = 0; // Pointer for arrival
        int j = 0; // Pointer for departure

        // Step 3: Traverse both arrays
        while (i < n && j < n) {
            // If next train arrives before or at the time the current one departs
            if (arr[i] <= dep[j]) {
                platforms++;     // Need one more platform
                i++;             // Move to next arrival
            } else {
                platforms--;     // One train has left, free one platform
                j++;             // Move to next departure
            }

            // Update maximum platforms needed
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }
}
