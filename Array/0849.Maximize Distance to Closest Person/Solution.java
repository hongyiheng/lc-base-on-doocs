class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0, n = seats.length;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                break;
            }
            ans++;
        }
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                break;
            }
            cnt++;
        }
        ans = Math.max(ans, cnt);
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                ans = Math.max(ans, (cnt + 1) / 2);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return ans;
    }
}