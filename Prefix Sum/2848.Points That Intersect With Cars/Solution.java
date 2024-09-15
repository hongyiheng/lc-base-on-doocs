class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] q = new int[110];
        for (List<Integer> e : nums) {
            q[e.get(0)]++;
            q[e.get(1) + 1]--;
        }
        int ans = 0, s = 0;
        for (int v : q) {
            s += v;
            if (s > 0) {
                ans++;
            }
        }
        return ans;
    }
}