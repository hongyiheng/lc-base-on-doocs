class Solution {
    public int addDigits(int num) {
        return dfs(num);
    }

    public int dfs(int num) {
        if (num < 10) {
            return num;
        }
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return dfs(ans);
    }
}