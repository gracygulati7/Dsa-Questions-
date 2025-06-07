// https://leetcode.com/problems/remove-outermost-parentheses/description/

class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        // If this character is a closing bracket ')'
        // we finished one group, so reduce count by 1
        if (s.charAt(i) == ')') {
            count--;
        }
    
        // If count is NOT zero, it means we are inside some brackets,
        // not the outermost ones, so we add this character to the result
        if (count != 0) {
            res.append(s.charAt(i));
        }
    
        // If this character is an opening bracket '('
        // we started a new group, so increase count by 1
        if (s.charAt(i) == '(') {
            count++;
        }
      }
      return res.toString();
    }
}
