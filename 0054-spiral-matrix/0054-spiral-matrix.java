class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        

        List<Integer> ans = new ArrayList<>();

        int sr = 0;
        int er = matrix.length - 1;
        int sc = 0;
        int ec = matrix[0].length - 1;

        while (sr <= er && sc <= ec) {

            // Traverse Top Row
            for (int j = sc; j <= ec; j++) {
                ans.add(matrix[sr][j]);
            }

            // Traverse Right Column
            for (int i = sr + 1; i <= er; i++) {
                ans.add(matrix[i][ec]);
            }

            // Traverse Bottom Row
            if (sr < er) {
                for (int j = ec - 1; j >= sc; j--) {
                    ans.add(matrix[er][j]);
                }
            }

            // Traverse Left Column
            if (sc < ec) {
                for (int i = er - 1; i > sr; i--) {
                    ans.add(matrix[i][sc]);
                }
            }

            sr++;
            sc++;
            er--;
            ec--;
        }

        return ans;
    }
}