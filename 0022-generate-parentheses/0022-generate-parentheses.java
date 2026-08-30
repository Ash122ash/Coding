class Solution {
    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>();

        // dp[0] = [""]
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {

            List<String> current = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                List<String> inside = dp.get(j);
                List<String> after = dp.get(i - 1 - j);

                for (String a : inside) {
                    for (String b : after) {

                        current.add("(" + a + ")" + b);
                    }
                }
            }

            dp.add(current);
        }

        return dp.get(n);
    }
}