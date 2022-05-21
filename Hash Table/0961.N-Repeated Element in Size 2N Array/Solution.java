class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        int[] cnt = new int[10001];
        for (int v : nums) {
            cnt[v]++;
            if (cnt[v] == n) {
                return v;
            }
        }
        return -1;
    }
}