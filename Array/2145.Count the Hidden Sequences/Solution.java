class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int last = lower, mi = lower, mx = lower;
        for (int v : differences) {
            int cur = last + v;
            mi = Math.min(mi, cur);
            mx = Math.max(mx, cur);
            last = cur;
        }
        return (int)Math.max(0, (long)upper - mx + 1 - Math.max(0, lower - mi));
    }
}