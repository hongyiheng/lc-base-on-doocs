class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int mx = 0, ans = divisors[0];
        for (int d : divisors) {
            int cnt = 0;
            for (int v : nums) {
                if (v % d == 0) {
                    cnt++;
                }
            }
            if (cnt > mx || (cnt == mx && ans > d)) {
                ans = d;
                mx = cnt;
            }
        }
        return ans;
    }
}