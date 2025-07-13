import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr={4,10,5,8,20,15,3,12};
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            // we pop the element which is greater than current element since we need smaller element
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            // if stack is empty means theres no smaller element to the left of current element
            if(st.isEmpty()){
                System.out.print(-1 +" ");
            }
            // if we find an element which is smaller than current element we print it 
            else{
                System.out.print(st.peek()+" ");
            }
            // and we push current element to the stack
            st.push(arr[i]);
        }
    }
}
