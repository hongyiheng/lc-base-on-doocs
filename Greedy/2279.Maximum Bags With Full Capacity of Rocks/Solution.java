class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, ans = 0;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(q);
        for (int v : q) {
            if (v > additionalRocks) {
                break;
            }
            additionalRocks -= v;
            ans++;
        }
        return ans;
    }
}