class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    public int dfs (int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        }
        return pow(dfs(a, b, index - 1), 10) * pow(a, b[index]) % mod;
    }

    public int pow(int a, int b) {
        int ans = 1;
        a %= mod;
        while (b-- > 0) {
            ans = ans * a % mod;
        }
        return ans;
    }
}