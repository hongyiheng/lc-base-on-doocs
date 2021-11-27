class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] preSum = new int[n + 1];
        int basic = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1];
            if (grumpy[i - 1] == 1) {
                preSum[i] += customers[i - 1];
            } else {
                basic += customers[i - 1];
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int right = i + minutes >= n ? n : i + minutes;
            int diff = preSum[right] - preSum[i];
            res = Math.max(res, basic + diff);
        }
        return res;
    }
}