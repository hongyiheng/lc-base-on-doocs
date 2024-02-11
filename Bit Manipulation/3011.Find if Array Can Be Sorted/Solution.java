class Solution {

    public int bitCnt(int x) {
        int ans = 0;
        while (x > 0) {
            x -= x & -x;
            ans++;
        }
        return ans;
    }

    public boolean canSortArray(int[] nums) {
        int mx = 0, lastMx = 0, lastBit = 0;
        for (int v : nums) {
            int curBit = bitCnt(v);
            if (v < lastMx || (v < mx && curBit != lastBit)) {
                return false;
            }
            if (curBit != lastBit) {
                lastMx = mx;
            }
            mx = Math.max(mx, v);
            lastBit = curBit;
        }
        return true;
    }
}