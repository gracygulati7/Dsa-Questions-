// https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        int actual=0, curr=0;
        for(int i=1;i<=nums.length;i++){
            actual+=i;
        }
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
        }
        return actual-curr;
    }
}
