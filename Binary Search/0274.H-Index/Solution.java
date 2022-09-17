class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(citations, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x) {
        int cnt = 0;
        for (int v : nums) {
            if (v >= x) {
                cnt++;
            }
        }
        return cnt >= x;
    }
}