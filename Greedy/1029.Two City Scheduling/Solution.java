class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int ans = 0, n = costs.length;
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
            q.add(costs[i][1] - costs[i][0]);
        }
        Collections.sort(q);
        for (int i = 0; i < n / 2; i++) {
            ans += q.get(i);
        }
        return ans;
    }
}
