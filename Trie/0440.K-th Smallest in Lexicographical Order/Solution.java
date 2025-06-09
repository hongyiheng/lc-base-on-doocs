class Solution {

    int n;

    public long getCnt(int x) {
        long cnt = 0;
        long l = x, r = x + 1;
        while (l <= n) {
            cnt += Math.min(n + 1, r) - l;
            l *= 10;
            r *= 10;
        }
        return cnt;
    }

    public int findKthNumber(int n, int k) {
        this.n = n;
        int cur = 1;
        k--;
        while (k > 0) {
            long cnt = getCnt(cur);
            if (k >= cnt) {
                cur++;
                k -= cnt;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
}