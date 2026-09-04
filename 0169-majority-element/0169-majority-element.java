class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int a=(int)n/2;
        HashMap<Integer,Integer>b=new HashMap<>();
        for(int num:nums){
            int count = b.getOrDefault(num, 0) + 1;
            b.put(num, count);

            if (count > a) {
                return num;
            }
        }

        return -1;  
    }
}