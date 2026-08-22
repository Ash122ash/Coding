
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] a = new int[n];
        HashMap<Integer, Integer> b = new HashMap<>();

        // Count outgoing/connected edges per row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    b.put(i, b.getOrDefault(i, 0) + 1);
                } else {
                    b.put(i, b.getOrDefault(i, 0));
                }
            }
        }

        // Transfer degree counts from map to array
        for (int i = 0; i < n; i++) {
            a[i] = b.getOrDefault(i, 0);
        }

        return a;
    }
}