class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int m = dist.length;
        if (m > Math.ceil(hour)) {
            return -1;
        }
        int left = 1;
        int right = (int) 1e7;
        for (int num : dist) {
            right = Math.max(num, right);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] dist, double hour, int speed) {
        double cost = 0;
        for (int i = 0; i < dist.length; i++) {
            double temp = dist[i] * 1.00 / (double) speed;
            if (i != dist.length - 1) {
                cost += Math.ceil(temp);
            } else {
                cost += temp;
            }
        }
        return cost <= hour;
    }
}