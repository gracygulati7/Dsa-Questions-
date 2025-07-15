// https://www.geeksforgeeks.org/problems/page-faults-in-lru5603/0

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        int hits = 0, misses = 0;

        // List to act as the cache (storing recently used pages)
        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int curr = pages[i];

            if (cache.contains(curr)) {
                hits++; // Page is already in cache → hit

                // Remove value, not index: remove(Object o), not remove(int index)
                cache.remove((Integer) curr);

                // Remove the value from its old position to re-add it at the end,
                // marking it as the most recently used and avoiding accidental removal during future misses
                cache.add(curr); 
            } else {
                misses++; // Page not in cache → miss (page fault)

                if (cache.size() == C) { // if cache size reached its maximum capacity
                    cache.remove(0); // Remove oldest page (index 0)
                }

                cache.add(curr); // Add new page to cache
            }
        }
        return misses; // Return total page faults
    }
}
