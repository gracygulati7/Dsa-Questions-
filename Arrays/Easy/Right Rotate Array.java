// https://leetcode.com/problems/rotate-array/description/
// 1st approrach - optimized

class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(k==0) return;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums, int st, int end){
        while(st<end){
            int temp=nums[st];
            nums[st]=nums[end];
            nums[end]=temp;
            st++; end--;
        }
    }
}

// 2nd approach - my approach but it wont work for very long test cases
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        for(int i=0;i<k;i++){
            rotatearr(nums);
        }
    }
    public void rotatearr(int nums[]){
        int n=nums.length;
        int temp=nums[n-1];
        for(int i=n-1;i>0;i--){
            nums[i]=nums[i-1];
        }
        nums[0]=temp;
    }
}
