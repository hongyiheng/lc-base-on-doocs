class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        boolean carry = false;
        while (m >= 0 || n >= 0) {
            int v = carry ? 1 : 0;
            if (m >= 0) {
                v += num1.charAt(m) - '0';
            }
            if (n >= 0) {
                v += num2.charAt(n) - '0';
            }
            ans.append(v % 10);
            carry = v >= 10;
            m--;
            n--;
        }
        if (carry) {
            ans.append("1");
        }
        return ans.reverse().toString();
    }
}