class Solution {

    List<String> ans = new ArrayList<>();
    int n;

    public void dfs(int i, char[] cs) {
        if (i == n) {
            ans.add(new String(cs));
            return;
        }
        if (cs[i - 1] == '1') {
            cs[i] = '0';
            dfs(i + 1, cs);
        }
        cs[i] = '1';
        dfs(i + 1, cs);
    }

    public List<String> validStrings(int n) {
        this.n = n;
        char[] cs = new char[n];
        cs[0] = '0';
        dfs(1, cs);
        cs[0] = '1';
        dfs(1, cs);
        return ans;
    }
}