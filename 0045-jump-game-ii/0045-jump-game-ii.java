class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        // Initially, assume very large number of jumps
        Arrays.fill(dp, 10000);

        // Starting position needs 0 jumps
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // From index i, try every possible jump
            for (int j = 1; j <= nums[i] && i + j < n; j++) {

                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}