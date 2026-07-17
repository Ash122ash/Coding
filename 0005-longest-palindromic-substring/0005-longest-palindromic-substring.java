class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                String a = s.substring(i, j + 1);

                int k = 0;
                int l = a.length() - 1;
                boolean isPalindrome = true;

                while (k < l) {
                    if (a.charAt(k) != a.charAt(l)) {
                        isPalindrome = false;
                        break;
                    }
                    k++;
                    l--;
                }

                if (isPalindrome && a.length() > ans.length()) {
                    ans = a;
                }
            }
        }

        return ans;
    }
}