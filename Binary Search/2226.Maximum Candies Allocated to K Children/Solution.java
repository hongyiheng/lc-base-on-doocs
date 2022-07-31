class Solution {
    int[] candies;
    long k;

    public int maximumCandies(int[] candies, long k) {
        this.candies = candies;
        this.k = k;
        int left = 0, right = 0;
        for (int v : candies) {
            right = Math.max(right, v);
        }
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int x) {
        long cnt = 0;
        for (int v : candies) {
            cnt += v / x;
        }
        return cnt >= k;
    }
}