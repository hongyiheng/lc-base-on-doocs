class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] pre = new int[n];
        int[] tail = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 0;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                tail[i] = tail[i + 1] + 1;
            } else {
                tail[i] = 0;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (pre[i] >= time && tail[i] >= time) {
                ans.add(i);
            }
        }
        return ans;
    }
}