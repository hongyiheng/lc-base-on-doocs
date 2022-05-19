class Solution {
    int[] nums;

    public int minMoves2(int[] nums) {
        this.nums = nums;
        int left = Integer.MAX_VALUE, right= Integer.MIN_VALUE;
        for (int v : nums) {
            left = Math.min(left, v);
            right = Math.max(right, v);
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            int cnt1 = getDiff(mid);
            int cnt2 = getDiff(mid + 1);
            if (cnt2 < cnt1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return getDiff(left);
    }

    public int getDiff(int x) {
        int cnt = 0;
        for (int v : nums) {
            cnt += Math.abs(v - x);
        }
        return cnt;
    }
}