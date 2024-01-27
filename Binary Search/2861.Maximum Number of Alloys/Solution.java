class Solution {
    List<List<Integer>> composition;
    List<Integer> stock;
    List<Integer> cost;

    public boolean check(int x, int t, int n, long budget) {
        for (int i = 0; i < n; i++) {
            int v = composition.get(x).get(i);
            if (stock.get(i) >= (long)t * v) {
                continue;
            }
            budget -= ((long) t * v - stock.get(i)) * cost.get(i);
            if (budget < 0) {
                return false;
            }
        }
        return true;
    }


    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        this.composition = composition;
        this.stock = stock;
        this.cost = cost;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int l = 0, r = (int)1e9;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (check(i, mid, n, (long)budget)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }
}