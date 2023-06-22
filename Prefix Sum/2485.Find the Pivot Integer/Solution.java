class Solution {
    public int pivotInteger(int n) {
        int pre = 0, suf = 0;
        for (int i = 0; i < n + 1; i++) {
            suf += i;
        }
        for (int i = 0; i < n + 1; i++) {
            pre += i;
            if (pre == suf) {
                return i;
            }
            suf -= i;
        }
        return -1;
    }
}