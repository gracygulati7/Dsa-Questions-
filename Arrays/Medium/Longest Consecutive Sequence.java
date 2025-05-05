// https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Arrays.sort(nums); 
        int length=1, maxlen=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) continue;
            else if(nums[i]-nums[i-1]==1){
                length++;
                maxlen=Math.max(maxlen,length);
            }
            else length=1;
        }
        return maxlen;
    }
}
