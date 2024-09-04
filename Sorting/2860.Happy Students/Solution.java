class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ans = nums.get(0) > 0 ? 1 : 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            int v = nums.get(i);
            if (v < i + 1) {
                if (i < n - 1 && nums.get(i + 1) <= i + 1) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}