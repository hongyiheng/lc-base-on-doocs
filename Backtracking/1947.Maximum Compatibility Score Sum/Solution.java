class Solution {
    int m, n;
    int[][] students;
    int[][] mentors;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        n = students[0].length;
        this.students = students;
        this.mentors = mentors;
        return dfs(0, 0, 0);
    }

    public int dfs(int i, int use, int cur) {
        if (i == m) {
            return cur;
        }
        int ans = cur;
        for (int j = 0; j < m; j++) {
            if ((use >> j & 1) == 1) {
                continue;
            }
            ans = Math.max(ans, dfs(i + 1, use | (1 << j), cur + getScore(i, j)));
        }
        return ans;
    }

    public int getScore(int i, int j) {
        int ans = 0;
        for (int k = 0; k < n; k++) {
            if (students[i][k] == mentors[j][k]) {
                ans++;
            }
        }
        return ans;
    }
}