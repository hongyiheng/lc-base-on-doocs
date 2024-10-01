class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int s = 0;
        for (int v : arr) {
            s += v;
        }
        if (s % 3 != 0) {
            return false;
        }
        int t = s / 3, cur = 0, cnt = 0;
        for (int v : arr) {
            cur += v;
            if (cur == t) {
                cur = 0;
                cnt++;
            }
        }
        return cnt >= 3;
    }
}