class Solution {

    List<Integer> ans;
    int n;

    public void dfs(int x) {
        if (x > n) {
            return;
        }
        ans.add(x);
        for (int i = 0; i < 10; i++) {
            int nx = x * 10 + i;
            dfs(nx);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        if (n < 10) {
            for (int i = 1; i < n + 1; i++) {
                ans.add(i);
            }
            return ans;
        }
        this.n = n;
        for (int i = 1; i < 10; i++) {
            dfs(i);
        }
        return ans;
    }
}