class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            if (n % -2 != 0) {
                ans.append("1");
                n -= 1;
            } else {
                ans.append("0");
            }
            n /= -2;
        }
        return ans.reverse().toString();
    }
}