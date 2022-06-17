class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else {
                return 1;
            }
        });
        double s = 0;
        for (int v : nums) {
            q.add((double) v);
            s += v;
        }
        double target = s / 2;
        int ans = 0;
        while (s > target) {
            double cur = q.poll();
            s -= cur / 2;
            q.add(cur / 2);
            ans++;
        }
        return ans;
    }
}