class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int ans = 0, left = 0;
        for (int[] t : tasks) {
            if (left >= t[1]) {
                left -= t[0];
            } else {
                ans += t[1] - left;
                left = t[1] - t[0];
            }
        }
        return ans;
    }
}
