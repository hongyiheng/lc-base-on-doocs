class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] v : boxTypes) {
            int n = v[0], s = v[1];
            ans += Math.min(n, truckSize) * s;
            truckSize -= n;
            if (truckSize <= 0) {
                break;
            }
        }
        return ans;
    }
}
