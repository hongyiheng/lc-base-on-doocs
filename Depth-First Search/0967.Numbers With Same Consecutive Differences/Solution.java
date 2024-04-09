class Solution {

    List<Integer> ans = new ArrayList<>();

    public void dfs(int x, int n, int k) {
        if (String.valueOf(x).length() == n) {
            ans.add(x);
            return;
        }
        int last = x % 10;
        if (last - k >= 0) {
            dfs(x * 10 + last - k, n, k);
        }
        if (k != 0 && last + k < 10) {
            dfs(x * 10 + last + k, n, k);
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            dfs(i, n, k);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}