// https://leetcode.com/problems/rotate-image/description/

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;         
        int col = matrix[0].length;    

        // Step 1: Transpose the matrix (swap rows with columns)
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {  // j starts from i to avoid repeating swaps
                // Swap element at [i][j] with [j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to get the final rotated matrix
        for (int i = 0; i < row; i++) {
            reverserow(matrix[i]);  // Reverse the current row
        }
    }

    void reverserow(int[] rows) {
        int st = 0, end = rows.length - 1;
        while (st < end) {
            int temp = rows[st];
            rows[st] = rows[end];
            rows[end] = temp;
            st++;  
            end--;
        }
    }
}
