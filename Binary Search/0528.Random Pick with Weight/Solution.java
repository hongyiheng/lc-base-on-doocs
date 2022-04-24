class Solution {
    int[] pre;
    Random r;
    public Solution(int[] w) {
        int n = w.length;
        pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + w[i];
        }
        r = new Random();
    }

    public int pickIndex() {
        int n = pre.length;
        int t = r.nextInt(pre[n - 1]) + 1;
        int left = 1, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (pre[mid] < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */