class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int v : energy) {
            if (v >= initialEnergy) {
                int d = v - initialEnergy + 1;
                ans += d;
                initialEnergy += d;
            }
            initialEnergy -= v;
        }
        for (int v : experience) {
            if (v >= initialExperience) {
                int d = v - initialExperience + 1;
                ans += d;
                initialExperience += d;
            }
            initialExperience += v;
        }
        return ans;
    }
}