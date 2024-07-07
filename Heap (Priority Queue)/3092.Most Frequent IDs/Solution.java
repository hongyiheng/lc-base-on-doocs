class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, Long> cnt = new HashMap<>();
        PriorityQueue<long[]> rk = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            int v = nums[i], c = freq[i];
            cnt.put(v, cnt.getOrDefault(v, 0L) + c);
            rk.add(new long[]{cnt.get(v), v});
            while (rk.peek()[0] != cnt.get((int)rk.peek()[1])) {
                rk.poll();
            }
            ans[i] = rk.peek()[0];
        }
        return ans;
    }
}