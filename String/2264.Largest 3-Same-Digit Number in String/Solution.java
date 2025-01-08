class Solution {
    public String largestGoodInteger(String num) {
        int mx = -1, cnt = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) == num.charAt(i)) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= 3) {
                mx = Math.max(mx, num.charAt(i) - '0');
            }
        }
        return mx == -1 ? "" :  "" + mx + mx + mx;
    }
}