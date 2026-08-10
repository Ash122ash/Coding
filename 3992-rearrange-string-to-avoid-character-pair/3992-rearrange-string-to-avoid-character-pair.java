class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ans = new StringBuilder();

        // First put all y
        for (char c : s.toCharArray()) {
            if (c == y) {
                ans.append(c);
            }
        }

        // Then put all other characters
        for (char c : s.toCharArray()) {
            if (c != x && c != y) {
                ans.append(c);
            }
        }

        // Finally put all x
        for (char c : s.toCharArray()) {
            if (c == x) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}