class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] f = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int a = energyDrinkA[i - 1];
            int b = energyDrinkB[i - 1];
            f[i][0] = f[i - 1][0] + a;
            f[i][1] = f[i - 1][1] + b;
            if (i >= 2) {
                f[i][0] = Math.max(f[i][0], f[i - 2][1] + a);
                f[i][1] = Math.max(f[i][1], f[i - 2][0] + b);
            }
        }
        return Math.max(f[n][0], f[n][1]);
    }
}