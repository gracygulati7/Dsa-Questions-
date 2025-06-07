// https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        if(new String(a).equals(new String(b))) return true;
        return false;
        // alternate: return Arrays.equals(a,b);
    }
}
