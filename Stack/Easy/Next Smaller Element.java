import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr={3,10,5,1,15,10,7,6};
        List<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        // since we need smaller element to the right side we iterate from right to left
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }
            else{
                res.add(st.peek());
            }
            st.push(arr[i]);
        }
        // since we would get the next smaller elements from right to left since we iterated from right to left,
        // we need to reverse the order of elements to get correct output from left to right
        Collections.reverse(res);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
