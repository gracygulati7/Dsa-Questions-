// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class Solution {
    // Function to find the maximum number of non-overlapping meetings 
    // that can be scheduled in a single meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length; // Total number of meetings

        // Step 1: Create a 2D array to hold start and end times together
        int[][] meetings = new int[n][2];

        // Step 2: Fill the meetings array with start[i] and end[i]
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i]; // start time
            meetings[i][1] = end[i];   // end time
        }

        // Step 3: Sort meetings based on their end times 
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        // Step 4: Initialize count with 1 (we will select the first meeting)
        int count = 1;

        // Keep track of the end time of the last selected meeting
        int ending = meetings[0][1];

        // Step 5: Loop through the remaining meetings
        for (int i = 1; i < n; i++) {
            int curr_st = meetings[i][0];   // current meeting's start time
            int curr_end = meetings[i][1];  // current meeting's end time

            // Step 6: If the current meeting starts after the last meeting ends
            if (curr_st > ending) {
                count++;            // We can attend this meeting
                ending = curr_end;  // Update the ending time to current meeting's end
            }
        }
        return count;
    }
}
