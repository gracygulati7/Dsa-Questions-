// https://leetcode.com/problems/majority-element-ii/description/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        int n=nums.length, majority=n/3;
        for(int i=0;i<n;i++){
            int count=1;
            if(map.containsKey(nums[i])){
                count=map.get(nums[i])+1;
            }
            map.put(nums[i],count);
            if(count>majority && !result.contains(nums[i])){
                result.add(nums[i]);
            }
        }
        return result;
    }
}
