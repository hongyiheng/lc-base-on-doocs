class Solution {
    public int reinitializePermutation(int n) {
        int ans = 1, idx = n / 2;
        while (true) {
            if (idx == 1) {
                return ans;
            }
            if (idx % 2 == 0) {
                idx /= 2;
            } else {
                idx = n / 2 + (idx - 1) / 2;
            }
            ans++;
        }
    }
}