class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int l = 0, resL = 0, mx = 0, cur = 0;
        for (int r = 0; r < n; r++) {
            if (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    cur -= customers[l];
                }
                l++;
            }
            if (grumpy[r] == 1) {
                cur += customers[r];
            }
            if (cur > mx) {
                mx = cur;
                resL = l;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((resL <= i && i <= resL + minutes - 1) || grumpy[i] == 0) {
                ans += customers[i];
            }
        }
        return ans;
    }
}