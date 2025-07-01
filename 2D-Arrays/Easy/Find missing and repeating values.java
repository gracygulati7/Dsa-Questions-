// https://leetcode.com/problems/find-missing-and-repeated-values/

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length; int m=grid[0].length;
        int rep=0, miss=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        for(int num:map.keySet()){
            if(map.get(num)==2){
                rep=num;
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)){
                miss=i;
            }
        }
        return new int[] {rep,miss};
    }
}
