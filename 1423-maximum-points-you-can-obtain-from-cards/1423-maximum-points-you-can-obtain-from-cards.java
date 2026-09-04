class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currentSum = 0;

        // 1. Take the first k cards from the left
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }

        int maxsum = currentSum;
        int left = k - 1;
        int right = n - 1;

        // 2. Slide the window: remove from left, add from right
        while (left >= 0) {
            currentSum -= cardPoints[left];
            currentSum += cardPoints[right];
            maxsum = Math.max(maxsum, currentSum);
            left--;
            right--;
        }

        return maxsum;
    }
}