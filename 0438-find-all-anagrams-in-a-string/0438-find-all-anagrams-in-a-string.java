 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>result = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        if (n < k) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Frequency count for target string p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Expand the window by including s[right]
            sCount[s.charAt(right) - 'a']++;

            // Shrink the window if it exceeds size k
            if (right - left + 1 > k) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }

            // If the window size is exactly k, compare frequencies
            if (right - left + 1 == k) {
                if (Arrays.equals(pCount, sCount)) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}