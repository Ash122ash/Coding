class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();

        int[] dp = new int[n + 1];

        int count = 0;

        for (int i = n - m; i >= 0; i--) {

            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (sequence.charAt(i + j) != word.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                dp[i] = 1;

                if (i + m <= n) {
                    dp[i] += dp[i + m];
                }

                count = Math.max(count, dp[i]);
            }
        }

        return count;
    }
}