class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] q = new int[]{a, b, c};
        Arrays.sort(q);
        int ans = 0;
        while (q[1] > 0) {
            if (q[0] + q[1] > q[2]) {
                q[0]--;
                q[1]--;
            } else {
                q[1]--;
                q[2]--;
            }
            ans++;
            Arrays.sort(q);
        }
        return ans;
    }
}
