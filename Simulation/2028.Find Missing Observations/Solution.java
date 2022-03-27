class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int target = (m + n) * mean;
        for (int num : rolls) {
            target -= num;
        }
        if (target > n * 6 || target < n) {
            return new int[0];
        }
        int[] ans = new int[n];
        int avgNum = target / n;
        int other = target % n;
        Arrays.fill(ans, avgNum);
        for (int i = 0; i < other; i++) {
            ans[i]++;
        }
        return ans;
    }
}