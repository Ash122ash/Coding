class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int a = 0;
        int s = 0;
        int l = n - 1;

        while (s < l) {
            int j = Math.min(height[s], height[l]);
            int k = l - s;
            a = Math.max(a, j * k);

            if (height[s] < height[l]) {
                s++;
            } else {
                l--;
            }
        }

        return a;
    }
}