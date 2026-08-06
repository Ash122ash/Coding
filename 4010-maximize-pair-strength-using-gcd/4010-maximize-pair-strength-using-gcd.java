class Solution {
    public long maxPairStrength(int[] nums) {

        long ans = 0;

        for(int i = 0 ; i < nums.length ;  i++){
            for(int j = i+1 ; j < nums.length; j++){
                int a = nums[i];
                int b = nums[j];
                int c = gcd(a,b);
                long temp = ((long)a*b)/ (long)(c*c);
                ans = Math.max(ans , temp);
            }
        }
        return ans;
    }
    public int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b , a%b);
    }
}