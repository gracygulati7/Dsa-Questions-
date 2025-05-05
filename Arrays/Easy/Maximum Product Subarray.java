// https://leetcode.com/problems/maximum-product-subarray/description/

class Solution {
    public int maxProduct(int[] nums) {
        int product=1, ans=Integer.MIN_VALUE;
      // left to right
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            ans=Math.max(ans,product);
            if(product==0){
                product=1;
            }
        }
        product=1;
      // right to left
        for(int i=nums.length-1;i>=0;i--){
            product*=nums[i];
            ans=Math.max(ans,product);
            if(product==0){
                product=1;
            }
        }
        return ans;
    }
}
