class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int v : nums.get(i)) {
                q.add(new int[]{v, i});
            }
        }
        q.sort((a, b) -> a[0] - b[0]);
        int m = q.size();
        int[] ans = new int[]{q.get(0)[0], q.get(m - 1)[0]};
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        while (r < m) {
            cnt.put(q.get(r)[1], cnt.getOrDefault(q.get(r)[1], 0) + 1);
            while (cnt.size() == n) {
                if (ans[1] - ans[0] > q.get(r)[0] - q.get(l)[0]) {
                    ans = new int[]{q.get(l)[0], q.get(r)[0]};
                }
                cnt.put(q.get(l)[1], cnt.get(q.get(l)[1]) - 1);
                if (cnt.get(q.get(l)[1]) == 0) {
                    cnt.remove(q.get(l)[1]);
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}