// https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length; int count=0, maxcount=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
            }
            else {
                maxcount=Math.max(maxcount,count);
                count=0;
            }
        }
        maxcount=Math.max(maxcount,count); // this line added for checking last element if its 1 bcoz the same line above works only if there is 0 after 1
        return maxcount;
    }
}
