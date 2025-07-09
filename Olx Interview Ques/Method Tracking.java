import java.util.*;
import java.time.*;
class Solution {
    public static Map<String,Integer> solve(List<String> logs){
        Map<String,String> entry=new HashMap<>();
        // LinkedHashMap used to maintain insertion order
        Map<String, Integer> ans=new LinkedHashMap<>();
        for(String str:logs){
            String[] parts=str.split(" ");
            String method=parts[0];
            String action=parts[1];
            String time=parts[2];
            if(action.equals("enter")){
                entry.put(method,time);
            }
            else if(action.equals("exit")){
                if(entry.containsKey(method)){
                    // if the current method's action is exit and if entry map contains the method, 
                    // so map would have the start time associated with the method,
                    // so we get the entry time and remove it from map since it has exited.
                    String start=entry.remove(method);
                    // the below line calculates the time between the entry and exit of the current method
                    // "time" here defines the the exit time of method and "start' defines the entry time of method we get from entry map
                    // it then converts the duration for which the method stays (entry -> exit) to minutes 
                    // but it gives it in double or long, so we need to explicity convert it to integer.
                    long mins=Duration.between(LocalTime.parse(start), LocalTime.parse(time)).toMinutes();
                    ans.put(method, (int) mins);
                }
                // // If a method exits without entering, mark it as -1.
                else {
                ans.put(method, -1);
                }
            }
        }
        // Add -1 for methods that entered but didn't exit
        for(String key:entry.keySet()){
            ans.put(key,-1);
        }
        return ans;
    }
  
    public static void main(String[] args) {
        List<String> logs=Arrays.asList(
            "method1 enter 11:00",
            "method2 enter 11:05",
            "method2 exit 11:10",
            "method1 exit 11:20",
            "method3 enter 11:30",
            "method4 exit 12:00");
        Map<String,Integer> res=solve(logs);
        for(String key:res.keySet()){
            System.out.println(key+" : "+res.get(key)+" minutes");
        }
    }
}


// TC: O(N) , SC: O(N)
