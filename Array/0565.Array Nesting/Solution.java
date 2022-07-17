class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length, ans = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cur = nums[i], cnt = 0;
            while (!used[cur]) {
                used[cur] = true;
                cur = nums[cur];
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}