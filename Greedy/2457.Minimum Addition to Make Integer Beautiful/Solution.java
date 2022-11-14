class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        char[] cs = ("0" + n).toCharArray();
        long ans = 0, cnt = 0;
        for (char c : cs) {
            cnt += c - '0';
        }
        int m = cs.length;
        for (int i = m - 1; i > 0; i--) {
            if (cnt <= target) {
                break;
            }
            if (cs[i] != '0') {
                long idx = (long) Math.pow(10, m - i - 1);
                ans += idx * (10 - (cs[i] - '0'));
                cnt -= (cs[i] - '0' - 1);
                cs[i] = '0';
                cs[i - 1] += 1;
            }
        }
        return ans;
    }
}
