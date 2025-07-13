class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Step 1: Map each element in nums2 to its next greater element
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            // Pop all elements smaller than or equal to current
            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            // If stack is empty → no greater element
            int nextGreater = st.isEmpty() ? -1 : st.peek();
            ngeMap.put(curr, nextGreater);

            // Push current element to stack
            st.push(curr);
        }

        // Step 2: Build result for nums1 from the map
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = ngeMap.get(nums1[i]);
        }

        return res;
    }
}
