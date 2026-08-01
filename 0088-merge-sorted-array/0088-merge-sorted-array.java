class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> a=new ArrayList<>();
        int z=0;
        int y=0;
        while(z<m && y<n){
        if(nums1[z]<nums2[y] ){
            a.add(nums1[z]);
            z++;
        }
        else{
            a.add(nums2[y]);
            y++;
        }}
        while (z < m) {
            a.add(nums1[z]);
            z++;
        }

        while (y < n) {
            a.add(nums2[y]);
            y++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = a.get(i);
        }
    }
}