class Solution {
    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }
}