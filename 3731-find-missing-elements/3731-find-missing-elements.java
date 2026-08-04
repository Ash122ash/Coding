class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int j=0;
        for(int i=nums[0] ;i<=nums[nums.length-1];i++){
            if(j<nums.length && i==nums[j] ){
                j++;
            }
            else{
                ans.add(i);
            }
            
        }

        
        return ans;
    }
}