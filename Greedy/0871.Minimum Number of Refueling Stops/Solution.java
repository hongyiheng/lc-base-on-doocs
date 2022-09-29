class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int f = startFuel, ans = 0;
        for (int[] v : stations) {
            if (f >= target) {
                return ans;
            }
            while (f < v[0] && !q.isEmpty()) {
                f += q.poll();
                ans++;
            }
            if (f >= v[0]) {
                q.add(v[1]);
            } else {
                return -1;
            }
        }
        while (f < target && !q.isEmpty()) {
            f += q.poll();
            ans++;
        }
        return f >= target ? ans : -1;
    }
}
