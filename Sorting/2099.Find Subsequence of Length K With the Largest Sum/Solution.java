class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(new int[]{i, nums[i]});
        }
        q.sort((a, b) -> b[1] - a[1]);
        q = q.subList(0, k);
        q.sort((a, b) -> a[0] - b[0]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.get(i)[1];
        }
        return ans;
    }
}