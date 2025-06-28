// Link: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

// we need to Schedule jobs smartly so that we finish the maximum number of them within their deadlines, while maximizing our total profit 
// (since we can't complete all jobs if there's a time clash) so we prioritize high profit jobs.
// There might be more jobs than time units since one job takes 1 unit of time — we can't just schedule one job per deadline. 
// we need to find available slots starting from deadline to 1. like if a job has deadline 3 then the job can be scheduled at any time slot ie 1, 2 or 3.
// we need maximum profit so we sort in descending order of profit and take the maximum or latest available time slot ≤ its deadline. 
// like for deadline 3 - try to take the 3rd time slot if not already occupied.
// lastly we Count how many jobs were done and add their profits.


import java.util.*;
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;

        // Step 1: Create job list of [deadline, profit]
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{deadline[i], profit[i]};
        }

        // Step 2: Sort jobs by profit (high to low)
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        // Step 3: Find the maximum deadline to know how many time slots we may need
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        // Step 4: Create a time slot array (1-based index)
        boolean[] slot = new boolean[maxDeadline + 1]; // slot[i] = true means slot i is occupied

        // Step 5: Try to assign each job to the latest available time slot ≤ deadline
        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int d = jobs[i][0]; // deadline
            int p = jobs[i][1]; // profit

            // Try to place in latest slot <= d (deadline)
            for (int j = d; j >= 1; j--) {
                if (!slot[j]) {
                    slot[j] = true;  // occupy this slot
                    count++;         // one more job done
                    sum += p;        // add profit
                    break;           // move to next job
                }
            }
        }

        // Step 6: Return [jobs done, total profit]
        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(sum);
        return result;
    }
}
