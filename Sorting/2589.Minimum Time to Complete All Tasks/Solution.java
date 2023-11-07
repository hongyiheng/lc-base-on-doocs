class Solution {
    public int findMinimumTime(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        boolean[] run = new boolean[tasks[n - 1][1] + 1];
        int ans = 0;
        for (int[] task : tasks) {
            int l = task[0], r = task[1], t = task[2];
            for (int i = l; i <= r; i++) {
                if (run[i]) {
                    t--;
                }
            }
            if (t <= 0) {
                continue;
            }
            for (int i = r; i >= l && t > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    t--;
                    ans++;
                }
            }
        }
        return ans;
    }
}