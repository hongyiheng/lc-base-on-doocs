class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int v : hours) {
            if (v >= target) {
                ans++;
            }
        }
        return ans;
    }
}