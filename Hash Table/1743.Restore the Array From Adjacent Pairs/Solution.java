class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> cnt = new HashMap<>();
        for (int[] v : adjacentPairs) {
            cnt.computeIfAbsent(v[0], k -> new ArrayList<>()).add(v[1]);
            cnt.computeIfAbsent(v[1], k -> new ArrayList<>()).add(v[0]);
        }
        int n = cnt.size();
        int[] ans = new int[n];
        for (var entry : cnt.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                ans[1] = entry.getValue().get(0);
            }
        }
        for (int i = 2; i < n; i++) {
            List<Integer> v = cnt.get(ans[i - 1]);
            if (v.get(0) == ans[i - 2]) {
                ans[i] = v.get(1);
            } else {
                ans[i] = v.get(0);
            }
        }
        return ans;
    }
}
