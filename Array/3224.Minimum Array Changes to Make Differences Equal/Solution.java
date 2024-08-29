class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int[] q = new int[n / 2];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            int x = Math.abs(nums[i] - nums[n - 1 - i]);
            q[i] = x;
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        List<int[]> kvs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            kvs.add(new int[]{entry.getKey(), entry.getValue()});
        }
        kvs.sort((a, b) -> b[1] - a[1]);
        int ans = n;
        for (int[] kv : kvs) {
            if (ans <= kvs.size() - kv[1]) {
                break;
            }
            int t = kv[0];
            int cnt = 0;
            for (int i = 0; i < q.length; i++) {
                if (q[i] == t) {
                    continue;
                }
                int r = n - i - 1;
                if (Math.max(nums[i] - k, 0) <= t && t <= Math.max(nums[i], k - nums[i])) {
                    cnt++;
                } else if (Math.max(nums[r] - k, 0) <= t && t <= Math.max(nums[r], k - nums[r])) {
                    cnt++;
                } else if (k >= t) {
                    cnt += 2;
                } else {
                    cnt = n;
                    break;
                }
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}