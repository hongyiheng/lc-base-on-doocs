class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> g = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            if (g.getOrDefault(x[i], - 1) < y[i]) {
                g.put(x[i], y[i]);
            }
        }
        int a = -1, b = -1, c = -1;
        for (int v : g.values()) {
            if (v >= a) {
                c = b;
                b = a;
                a = v;
            } else if (v >= b) {
                c = b;
                b = v;
            } else if (v >= c) {
                c = v;
            }
        }
        return c == -1 ? -1 : a + b + c;
    }
}