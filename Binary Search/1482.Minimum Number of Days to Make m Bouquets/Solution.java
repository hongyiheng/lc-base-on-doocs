class Solution {
    int[] bloomDay;
    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        int left = Integer.MAX_VALUE, right = 0;
        for (int v : bloomDay) {
            left = Math.min(left, v);
            right = Math.max(right, v);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return check(left, m, k) ? left : -1;
    }

    public boolean check(int x, int m, int k) {
        int cnt = 0;
        for (int v : bloomDay) {
            if (v <= x) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == k) {
                cnt = 0;
                m--;
            }
        }
        return m <= 0;
    }
}