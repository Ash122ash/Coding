class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }

        for (int j = 0; j < nums2.length; j++) {
            a[nums1.length + j] = nums2[j];
        }

        Arrays.sort(a);

        int n = a.length;

        if (n % 2 == 1) {
            return a[n / 2];
        } else {
            return (a[n / 2] + a[n / 2 - 1]) / 2.0;
        }
    }
}
    


 



