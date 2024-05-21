class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = energy[n - 1];
        for (int i = n - 1; i > n - k - 1; i--) {
            int s = 0;
            for (int j = i; j > -1; j -= k) {
                s += energy[j];
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}