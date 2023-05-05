class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int[] p : dominoes) {
            int v = (1 << p[0]) | (1 << p[1]);
            ans += mp.getOrDefault(v, 0);
            mp.put(v, mp.getOrDefault(v, 0) + 1);
        }
        return ans;
    }
}
