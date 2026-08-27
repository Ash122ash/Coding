class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int k = 0;  // index for s
        int l = 0;  // index for t

        while (k < n && l < m) {
            if (s.charAt(k) == t.charAt(l)) {
                k++;
                l++;
            } else {
                l++;
            }
        }

        return k == n;
    }
}