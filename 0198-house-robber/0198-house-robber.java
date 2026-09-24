class Solution {
    public int rob(int[] nums) {
        int prevv = 0; 
        int prev = 0; 
        for (int num : nums) {
        int current = Math.max(prev, prevv + num);
            prevv= prev;
            prev = current;
        }
        return prev;
    }
}