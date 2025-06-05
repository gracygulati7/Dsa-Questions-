// https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals by their starting times (ascending order)
        // This makes it easier to detect overlapping intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Initialize the start and end of the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 3: Create a list to store the merged intervals
        List<int[]> merged = new ArrayList<>();

        // Step 4: Iterate over the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int curr_st = intervals[i][0];  // current interval's start
            int curr_end = intervals[i][1]; // current interval's end

            // Step 5: If the current interval overlaps with the previous one
            if (curr_st <= end) {
                // Merge by updating the end to the max of current end and previous end
                end = Math.max(end, curr_end);
            } else {
                // Step 6: No overlap → add the previous interval to result
                merged.add(new int[]{start, end});
                // Update start and end to the current interval
                start = curr_st;
                end = curr_end;
            }
        }

        // Step 7: Add the last interval after the loop ends
        merged.add(new int[]{start, end});

        // Step 8: Convert the result list to an array and return
        return merged.toArray(new int[merged.size()][]);
    }
}
