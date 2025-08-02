class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> diff = new HashMap<>();
        int mi = basket1[0];
        for (int v : basket1) {
            diff.put(v, diff.getOrDefault(v, 0) + 1);
            mi = Math.min(mi, v);
        }
        for (int v : basket2) {
            diff.put(v, diff.getOrDefault(v, 0) - 1);
            mi = Math.min(mi, v);
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int k : diff.keySet()) {
            int d = diff.get(k);
            if ((d & 1) != 0) {
                return -1;
            }
            while (d > 0) {
                l.add(k);
                d -= 2;
            }
            while (d < 0) {
                r.add(k);
                d += 2;
            }
        }
        l.sort((a, b) -> a - b);
        r.sort((a, b) -> b - a);
        long ans = 0;
        for (int i = 0; i < l.size(); i++) {
            int a = l.get(i);
            int b = r.get(i);
            ans += Math.min(Math.min(a, b), 2 * mi);
        }
        return ans;
    }
}
