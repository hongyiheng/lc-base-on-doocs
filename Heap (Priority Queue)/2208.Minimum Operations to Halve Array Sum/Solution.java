class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> b.compareTo(a));
        long s = 0;
        for (int v : nums) {
            s += v;
            q.add(v * 1.0);
        }
        double t = s / 2.0, cur = 0;
        int ans = 0;
        while (cur < t) {
            double v = q.poll() / 2;
            cur += v;
            q.add(v);
            ans++;
        }
        return ans;
    }
}