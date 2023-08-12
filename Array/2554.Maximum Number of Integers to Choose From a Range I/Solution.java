class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        for (int v : banned) {
            ban.add(v);
        }
        int ans = 0, cur = 1;
        while (maxSum > 0) {
            while (ban.contains(cur)) {
                cur++;
            }
            if (cur > n || cur > maxSum) {
                break;
            }
            maxSum -= cur;
            ans++;
            cur++;
        }
        return ans;
    }
}