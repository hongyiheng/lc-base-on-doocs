class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> q = new ArrayList<>();
        for (int[] row : grid) {
            for (int v : row) {
                q.add(v);
            }
        }
        q.sort(Integer::compareTo);
        int mid = q.get(q.size() / 2);
        int ans = 0;
        for (int v : q) {
            if (Math.abs(v - mid) % x != 0) {
                return -1;
            }
            ans += Math.abs(v - mid) / x;
        }
        return ans;
    }
}