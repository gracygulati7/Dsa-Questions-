// https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        Arrays.sort(strs);
        StringBuilder ans=new StringBuilder();
        String first=strs[0], last=strs[n-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return ans.toString();
            }
            else ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
