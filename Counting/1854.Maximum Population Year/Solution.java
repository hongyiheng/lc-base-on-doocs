class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] pre = new int[2060];
        for (int[] log : logs) {
            pre[log[0]] += 1;
            pre[log[1]] -= 1;
        }
        int maxSum = 0, ans = 0, curSum = 0;;
        for (int i = 0; i < pre.length; i++) {
            curSum += pre[i];
            if (curSum > maxSum) {
                maxSum = curSum;
                ans = i;
            }
        }
        return ans;
    }
}