// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] seen=new boolean[nums.length+1];
        ArrayList<Integer> res=new ArrayList<>();
        for(int num:nums){
            seen[num]=true;
        }
        for(int i=1;i<=nums.length;i++){
            if(!seen[i]){
                res.add(i);
            }
        }
        return res;
    }
}
