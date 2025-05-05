// https://leetcode.com/problems/majority-element/description/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0; int majority=nums.length/2;
        for(int i=0;i<nums.length;i++){
            int count=1;
            if(map.containsKey(nums[i])){
                count=map.get(nums[i])+1;
            }
            map.put(nums[i],count);
            if(count>majority){
                res=nums[i];
                majority=count;
            }
        }
        return res;
    }
}
