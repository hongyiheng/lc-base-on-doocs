class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] cnt = new int[100001];
        for (int v : nums) {
            cnt[v]++;
        }
        int ans = -1, mx = 0;
        for (int i = 0; i < 100001; i++) {
            if (cnt[i] > mx && i % 2 == 0) {
                mx = cnt[i];
                ans = i;
            }
        }
        return ans;
    }
}
