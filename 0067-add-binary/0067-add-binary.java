class Solution {
    public String addBinary(String a, String b) {

        int n = a.length();
        int m = b.length();

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        while (n > 0 || m > 0) {

            int sum = carry;

            if (n > 0) {
                sum += a.charAt(n - 1) - '0';
                n--;
            }

            if (m > 0) {
                sum += b.charAt(m - 1) - '0';
                m--;
            }

            sb.append(sum % 2);

            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}