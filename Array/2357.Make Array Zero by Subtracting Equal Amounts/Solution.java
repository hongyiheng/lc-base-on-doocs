class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] s = new boolean[101];
        for (int v : nums) {
            s[v] = true;
        }
        int ans = 0;
        for (int i = 1; i < 101; i++) {
            ans += s[i] ? 1 : 0;
        }
        return ans;
    }
}
