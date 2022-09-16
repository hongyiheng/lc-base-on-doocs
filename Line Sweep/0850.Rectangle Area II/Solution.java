class Solution {
    public int rectangleArea(int[][] rectangles) {
        int mod = (int)1e9 + 7;
        List<Integer> xs = new ArrayList<>();
        for (int[] v : rectangles) {
            xs.add(v[0]);
            xs.add(v[2]);
        }
        Collections.sort(xs);
        long ans = 0;
        for (int i = 1; i < xs.size(); i++) {
            int left = xs.get(i - 1), right = xs.get(i);
            if (right == left) {
                continue;
            }
            List<int[]> ys = new ArrayList<>();
            for (int[] v : rectangles) {
                if (v[0] <= left && right <= v[2]) {
                    ys.add(new int[]{v[1], v[3]});
                }
            }
            Collections.sort(ys, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            int h = 0, d = -1, t = -1;
            for (int[] y : ys) {
                if (t < y[0]) {
                    h += t - d;
                    d = y[0];
                    t = y[1];
                } else if (t < y[1]) {
                    t = y[1];
                }
            }
            h += t - d;
            ans = (ans + (right - left) * 1L * h % mod) % mod;
        }
        return (int)ans;
    }
}