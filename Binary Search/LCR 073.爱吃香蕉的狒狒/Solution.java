class Solution {

    public boolean check(int[] piles, int t, int h) {
        int ans = 0;
        for (int x : piles) {
            ans += (x + t - 1) / t;
        }
        return ans <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (!check(piles, mid, h)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}