class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] q = new int[n][2];
        for (int i = 0; i < n; i++) {
            q[i][0] = difficulty[i];
            q[i][1] = profit[i];
        }
        Arrays.sort(q, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        List<int[]> stk = new ArrayList<>();
        for (int[] e : q) {
            if (!stk.isEmpty() && stk.get(stk.size() - 1)[1] >= e[1]) {
                continue;
            }
            stk.add(e);
        }
        int ans = 0;
        for (int w : worker) {
            int l = 0, r = stk.size() - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (stk.get(mid)[0] <= w) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (stk.get(r)[0] <= w) {
                ans += stk.get(r)[1];
            }
        }
        return ans;
    }
}