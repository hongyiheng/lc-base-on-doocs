class Solution {
    public boolean canAliceWin(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans += v >= 10 ? v : -v;
        }
        return ans != 0;
    }
}