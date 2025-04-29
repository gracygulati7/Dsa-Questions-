// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// 1st approach - using set

class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set=new LinkedHashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> list=new ArrayList<>(set);
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return set.size();
    }
}

// 2nd approach - two pointer 
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(i!=j && nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}
