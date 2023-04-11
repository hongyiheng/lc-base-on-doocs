class Solution {
    public long minimumMoney(int[][] transactions) {
        long loss = 0;
        for (int[] t : transactions) {
            if (t[0] > t[1]) {
                loss += t[0] - t[1];
            }
        }
        long earnMxCost = 0, lossMxBack = 0;
        for (int[] t : transactions) {
            if (t[0] < t[1]) {
                earnMxCost = Math.max(earnMxCost, t[0]);
            } else {
                lossMxBack = Math.max(lossMxBack, t[1]);
            }
        }
        return loss + Math.max(lossMxBack, earnMxCost);
    }
}