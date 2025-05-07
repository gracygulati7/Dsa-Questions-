// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int left=0, right=matrix[0].length-1, top=0, bottom=matrix.length-1;
        while(left<=right && top<=bottom){
          // top
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
          // right
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
          // bottom
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
          // left
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
