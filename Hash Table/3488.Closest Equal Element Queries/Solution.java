class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> last = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (last.containsKey(v)) {
                int lastPos = last.get(v);
                int d = Math.min(i - lastPos, n - i + first.get(v));
                ans[i] = d;
                if (ans[lastPos] == -1) {
                    ans[lastPos] = d;
                } else {
                    ans[lastPos] = Math.min(ans[lastPos], Math.min(i - lastPos, n - i + lastPos));
                }
                ans[first.get(v)] = Math.min(ans[first.get(v)], n - i + first.get(v));
            }
            last.put(v, i);
            first.putIfAbsent(v, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(ans[q]);
        }
        return res;
    }
}