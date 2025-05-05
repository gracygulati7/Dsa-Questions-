// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n=arr.length; int maxi=Integer.MIN_VALUE; 
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=maxi){
                res.add(arr[i]);
                maxi=arr[i];
            }
        }
        Collections.reverse(res);
        return res;
    }
}
