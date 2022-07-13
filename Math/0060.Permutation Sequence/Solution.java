class Solution {
    public String getPermutation(int n, int k) {
        int[] cnt = new int[10];
        cnt[0] = 1;
        for (int i = 1; i < 10; i++) {
            cnt[i] = cnt[i - 1] * i;
        }
        StringBuilder ans = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int num = cnt[i];
            for (int j = 1; j <= n; j++) {
                if (used[j]) {
                    continue;
                }
                if (k > num) {
                    k -= num;
                    continue;
                }
                used[j] = true;
                ans.append(j);
                break;
            }
        }
        return ans.toString();
    }
}