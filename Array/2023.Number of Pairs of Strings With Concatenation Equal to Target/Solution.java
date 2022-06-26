class Solution {
    public int numOfPairs(String[] nums, String target) {
        int m = nums.length, n = target.length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]).equals(target)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}