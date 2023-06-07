class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length, m = 2010;
        int[] gap = new int[m];
        for (int i = 0; i < n; i++) {
            gap[reward1[i] - reward2[i] + 1000]++;
        }
        for (int i = m - 1; i > -1; i--) {
            if (gap[i] > k) {
                gap[i] = k;
            }
            k -= gap[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (gap[reward1[i] - reward2[i] + 1000] > 0) {
                ans += reward1[i];
                gap[reward1[i] - reward2[i] + 1000]--;
            } else {
                ans += reward2[i];
            }
        }
        return ans;
    }
}
