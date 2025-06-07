// https://leetcode.com/problems/isomorphic-strings/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char charS=s.charAt(i);
            char charT=t.charAt(i);
            if(map.containsKey(charS)){
                if(map.get(charS)!=charT){
                    return false;
                }
            }
            else{
                if(map.containsValue(charT)){
                    return false;
                }
                else{
                    map.put(charS,charT);
                }
            }
        }
        return true;
    }
}
