class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        int[] left = new int[n], cnt = new int[2];
        long[] pre = new long[n + 1];
        int l = 0;
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r) - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[s.charAt(l++) - '0']--;
            }
            left[r] = l;
            pre[r + 1] = pre[r] + r - l + 1;
        }
        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int j = Math.min(y + 1, search(left, x));
            ans[i] = pre[y + 1] - pre[j] + (long) (j - x + 1) * (j - x) / 2;
        }
        return ans;
    }

    public int search(int[] nums, int t) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}