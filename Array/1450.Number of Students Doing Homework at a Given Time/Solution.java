class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] t = new int[1010];
        for (int v : startTime) {
            t[v]++;
        }
        for (int v : endTime) {
            t[v + 1]--;
        }
        int ans = 0;
        for (int i = 0; i < 1010; i++) {
            ans += t[i];
            if (i == queryTime) {
                break;
            }
        }
        return ans;
    }
}