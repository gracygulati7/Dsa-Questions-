// Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last index of each character
        Map<Character, Integer> map = new HashMap<>();

        // Initialize pointers and max length
        int left = 0;          // Start of current window
        int maxLen = 0;        // Maximum length of valid substring

        // Traverse the string using 'right' as the end of the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); // Current character

            // If character is already seen and inside the current window
            if (map.containsKey(c)) {
                // Move 'left' to one after the last occurrence of 'c'
                // Use Math.max to prevent moving 'left' backward
                left = Math.max(left, map.get(c) + 1);
            }

            // Update the last seen index of character 'c'
            map.put(c, right);

            // Calculate current window length and update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
