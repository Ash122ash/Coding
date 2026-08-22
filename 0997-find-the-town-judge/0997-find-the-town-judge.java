class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0]; // trusts someone
            int b = relation[1]; // is trusted

            trustScores[a]--; // Out-degree penalty
            trustScores[b]++; // In-degree reward
        }

        // The judge must have a score of exactly n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }}