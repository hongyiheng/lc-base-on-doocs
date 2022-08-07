class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int m = 1, k = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (++k == m) {
                k = 0;
                m++;
                ans++;
            }
        }
        return ans;
    }
}