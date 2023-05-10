class Solution {
    public int smallestRepunitDivByK(int k) {
        int cur = 1;
        for (int i = 1; i <= k; i++) {
            if (cur % k == 0) {
                return i;
            }
            cur = (cur % k * 10 + 1) % k;
        }
        return -1;
    }
}
