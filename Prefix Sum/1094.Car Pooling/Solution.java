class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] preSum = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            preSum[trips[i][1]] += trips[i][0];
            preSum[trips[i][2]] -= trips[i][0];
        }

        int cur = 0;
        for (int num : preSum) {
            if (cur > capacity) {
                return false;
            }
            cur += num;
        }
        return true;
    }
}