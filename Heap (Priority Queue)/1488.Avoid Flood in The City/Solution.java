class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> g = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (rains[i] != 0) {
                ans[i] = g.getOrDefault(rains[i], 0);
                g.put(rains[i], i);
            }
        }
        Set<Integer> s = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                if (s.contains(rains[i])) {
                    return new int[0];
                }
                if (ans[i] != 0) {
                    q.add(ans[i]);
                }
                s.add(rains[i]);
                ans[i] = -1;
            } else {
                int x = q.isEmpty() ? 1 : rains[q.poll()];
                ans[i] = x;
                s.remove(x);
            }
        }
        return ans;
    }
}