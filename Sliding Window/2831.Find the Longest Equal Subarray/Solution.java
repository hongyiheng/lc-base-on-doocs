class Solution {
    public int getMx(PriorityQueue<int[]> rk, Map<Integer, Integer> cnt) {
        while (!rk.isEmpty() && cnt.get(rk.peek()[1]) != rk.peek()[0]) {
            rk.poll();
        }
        return rk.peek()[0];
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        PriorityQueue<int[]> rk = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = -1, ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int v = nums.get(i);
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            rk.add(new int[]{cnt.get(v), v});
            while (i - l - getMx(rk, cnt) > k) {
                cnt.put(nums.get(++l), cnt.get(nums.get(l)) - 1);
            }
            ans = Math.max(ans, getMx(rk, cnt));
        }
        return ans;
    }
}