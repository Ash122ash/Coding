class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int k = 1; k < n; k++) {

            StringBuilder next = new StringBuilder();

            int count = 1;

            for (int i = 1; i < result.length(); i++) {

                if (result.charAt(i) == result.charAt(i - 1)) {
                    count++;
                } else {
                    next.append(count);
                    next.append(result.charAt(i - 1));

                    count = 1;
                }
            }

            next.append(count);
            next.append(result.charAt(result.length() - 1));

            result = next.toString();
        }

        return result;
    }
}