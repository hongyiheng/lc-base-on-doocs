class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int mid) {
        int ans = 0;
        for (int num : nums) {
            if (num >= mid) {
                ans++;
            }
        }
        return ans >= mid;
    }
}