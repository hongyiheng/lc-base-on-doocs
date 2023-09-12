class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] f = new boolean[numCourses][numCourses];
        for (int[] e : prerequisites) {
            int p = e[0], v = e[1];
            f[p][v] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    f[i][j] |= f[i][k] && f[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int p = q[0], v = q[1];
            ans.add(f[p][v]);
        }
        return ans;
    }
}