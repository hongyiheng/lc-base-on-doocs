class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int v : coins) {
            for (int j = v; j < amount + 1; j++) {
                f[j] += f[j - v];
            }
        }
        return f[amount];
    }
}