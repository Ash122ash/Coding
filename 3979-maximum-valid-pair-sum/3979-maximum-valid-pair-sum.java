class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int r=0;
        int p=0;
        int n=nums.length;
        for(int i=0;i<n-k;i++){
            p=Math.max(p,nums[i]);
            r=Math.max(r,p+nums[i+k]);

        }
        return r;
    }
}