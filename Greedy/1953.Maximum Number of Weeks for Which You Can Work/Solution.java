class Solution {
    public long numberOfWeeks(int[] milestones) {
        long s = 0, ans = 0, mx = 0;
        for (int v : milestones) {
            s += v;
            mx = Math.max(mx, v);
        }
        if (s - mx >= mx - 1) {
            return s;
        }
        return (s - mx) * 2 + 1;
    }
}