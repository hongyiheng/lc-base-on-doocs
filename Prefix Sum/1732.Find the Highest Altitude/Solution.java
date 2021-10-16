class Solution {
    public int largestAltitude(int[] gain) {
        int ans = Math.max(0, gain[0]);
        int last = gain[0];
        for (int i = 1; i < gain.length; i++) {
            last += gain[i];
            ans = Math.max(ans, last);
        }
        return ans;
    }
}