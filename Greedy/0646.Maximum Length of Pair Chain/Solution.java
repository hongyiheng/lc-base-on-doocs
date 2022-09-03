class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1, cur = pairs[0][1];
        for (int[] p : pairs) {
            if (p[0] > cur) {
                cur = p[1];
                ans++;
            }
        }
        return ans;
    }
}