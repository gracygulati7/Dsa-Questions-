// https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0

class Solution {
    public static int largest(int[] arr) {
        // code here
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        return largest;
    }
}
