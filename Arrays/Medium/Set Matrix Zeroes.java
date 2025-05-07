// https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length; int col=matrix[0].length;
        int[][] mat=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<col;k++){
                        mat[i][k]=0;
                    }
                    for(int k=0;k<row;k++){
                        mat[k][j]=0;
                    }
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=mat[i][j];
            }
        }
    }
}
