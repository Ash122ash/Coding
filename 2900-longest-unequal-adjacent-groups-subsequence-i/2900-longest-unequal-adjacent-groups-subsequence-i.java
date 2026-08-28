class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        List<String> ans = new ArrayList<>();

        // Start with the first word
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            // Add word only when group changes
            if (groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }

        return ans;
    }
}