class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        List<Integer>[] cnt = new List[32];
        for (int i = 0; i < 32; i++) {
            cnt[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            for (int j = 0; j < 32; j++) {
                if (((v >> j) & 1) == 1) {
                    cnt[j].add(i);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1;
            for (int j = 0; j < 32; j++) {
                if (cnt[j].isEmpty()) {
                    continue;
                }
                int l = 0, r = cnt[j].size() - 1;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (cnt[j].get(mid) < i) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                if (cnt[j].get(r) >= i) {
                    t = Math.max(t, cnt[j].get(r) - i + 1);
                }
            }
            ans[i] = t;
        }
        return ans;
    }
}
