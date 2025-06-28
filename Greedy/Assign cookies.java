// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length; // number of children
        int m = s.length; // number of cookies

        // Step 1: Sort the greed factors and cookie sizes in ascending order
        Arrays.sort(g); // Least greedy child first
        Arrays.sort(s); // Smallest cookie first

        // Step 2: Use two pointers to traverse both arrays
        int i = 0; // pointer for children
        int j = 0; // pointer for cookies
        int count = 0; // to count the number of content children

        // Step 3: Try to assign cookies while both arrays have elements
        while (i < n && j < m) {
            // If the current cookie can satisfy the current child's greed
            if (g[i] <= s[j]) {
                // Assign the cookie to the child
                count++; // one more child is content
                i++;     // move to next child
                j++;     // move to next cookie
            } else {
                // If the cookie is too small, try the next bigger cookie
                j++;
            }
        }

        // Step 4: Return the total number of content children
        return count;
    }
}
