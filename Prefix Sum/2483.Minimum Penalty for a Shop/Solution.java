class Solution {
    public int bestClosingTime(String customers) {
        int n = 0, y = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                y++;
            }
        }
        customers += "N";
        int ans = 0, cur = 0x3f3f3f3f;
        for (int i = 0; i < customers.length(); i++) {
            if (cur > n + y) {
                cur = n + y;
                ans = i;
            }
            if (customers.charAt(i) == 'Y') {
                y--;
            } else {
                n++;
            }
        }
        return ans;
    }
}
