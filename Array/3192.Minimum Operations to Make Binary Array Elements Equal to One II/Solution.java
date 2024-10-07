class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        boolean f = false;
        for (int v : nums) {
            v = f ? v ^ 1 : v;
            if (v == 0) {
                ans++;
                f = !f;
            }
        }
        return ans;
    }
}