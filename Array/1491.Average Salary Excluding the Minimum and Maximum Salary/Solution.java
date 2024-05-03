class Solution {
    public double average(int[] salary) {
        int mi = (int)1e9, mx = 0;
        long ans = 0;
        for (int v : salary) {
            if (mi > v) {
                mi = v;
            }
            if (mx < v) {
                mx = v;
            }
            ans += v;
        }
        return (1.0 * ans - mi - mx) / (salary.length - 2);
    }
}