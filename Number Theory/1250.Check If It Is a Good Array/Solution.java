class Solution {
    public boolean isGoodArray(int[] nums) {
        int cur = nums[0];
        for (int v : nums) {
            cur = gcd(cur, v);
            if (cur == 1) {
                return true;
            }
        }
        return false;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}