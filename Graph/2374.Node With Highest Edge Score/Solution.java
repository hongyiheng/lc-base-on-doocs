class Solution {
    public int edgeScore(int[] edges) {
        int ans = 0, n = edges.length;
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[edges[i]] += i;
            if ((score[edges[i]] > score[ans]) || score[edges[i]] == score[ans] && edges[i] < ans) {
                ans = edges[i];
            }
        }
        return ans;
    }
}