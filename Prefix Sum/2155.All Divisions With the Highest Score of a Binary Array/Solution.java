class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[][] pre = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            pre[i + 1][0] = pre[i][0];
            pre[i + 1][1] = pre[i][1];
            if (nums[i] == 0) {
                pre[i + 1][0]++;
            } else {
                pre[i + 1][1]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int mx = 0;
        for (int i = 0; i < n + 1; i++) {
            int cur = pre[i][0] + pre[n][1] - pre[i][1];
            if (cur > mx) {
                mx = cur;
                ans = new ArrayList<>();
                ans.add(i);
            } else if (cur == mx) {
                ans.add(i);
            }
        }
        return ans;
    }
}