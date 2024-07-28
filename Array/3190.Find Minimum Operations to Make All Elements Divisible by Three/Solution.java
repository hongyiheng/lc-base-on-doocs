class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            if (v % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}