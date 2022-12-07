class Solution {

    Map<Integer, List<Integer>> mp = new HashMap<>();
    int[][] roads;
    long seats, ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        this.roads = roads;
        this.seats = seats;
        ans = 0;
        for (int[] v : roads) {
            mp.computeIfAbsent(v[0], k -> new ArrayList<>()).add(v[1]);
            mp.computeIfAbsent(v[1], k -> new ArrayList<>()).add(v[0]);
        }
        dfs(0, -1);
        return ans;
    }

    public int dfs(int u, int p) {
        int cnt = 1;
        for (int v : mp.getOrDefault(u, new ArrayList<>())) {
            if (v != p) {
                cnt += dfs(v, u);
            }
        }
        if (u != 0) {
            ans += (cnt + seats - 1) / seats;
        }
        return cnt;
    }
}
