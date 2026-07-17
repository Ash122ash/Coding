import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] arr = new int[n][2];

        int k = 0;

        arr[k][0] = intervals[0][0];
        arr[k][1] = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] <= arr[k][1]) {

                arr[k][1] = Math.max(arr[k][1], intervals[i][1]);

            } else {

            
                k++;
                arr[k][0] = intervals[i][0];
                arr[k][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(arr, k + 1);
    }
}