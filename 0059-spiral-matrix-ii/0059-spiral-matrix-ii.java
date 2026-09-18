class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int val = 1;

        while (val <= n * n) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = val++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = val++;
            }
            right--;

            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = val++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = val++;
            }
            left++;
        }

        return matrix;
    }
}