class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if (currentEnergy < enemyEnergies[0]) {
            return 0;
        }
        long ans = currentEnergy / enemyEnergies[0];
        currentEnergy %= enemyEnergies[0];
        for (int i = enemyEnergies.length - 1; i > 0; i--) {
            currentEnergy += enemyEnergies[i];
            ans += currentEnergy / enemyEnergies[0];
            currentEnergy %= enemyEnergies[0];
        }
        return ans;
    }
}