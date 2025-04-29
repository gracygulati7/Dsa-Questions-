// https://www.geeksforgeeks.org/problems/second-largest3735/1

class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest=Integer.MIN_VALUE, seclargest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                seclargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>seclargest && arr[i]!=largest){
                seclargest=arr[i];
            }
        }
        if(seclargest==Integer.MIN_VALUE){
            return -1;
        }
        return seclargest;
    }
}
