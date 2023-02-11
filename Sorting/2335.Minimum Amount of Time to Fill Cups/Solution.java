class Solution {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] > 0 && amount[1] > 0 && amount[2] > 0) {
            Arrays.sort(amount);
            amount[2]--;
            amount[0]--;
            ans++;
        }
        Arrays.sort(amount);
        return ans + Math.max(amount[1], amount[2]);
    }
}
