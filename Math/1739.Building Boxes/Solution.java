class Solution {
    public int minimumBoxes(int n) {
        int bottom = 0, incr = 0, s = 0;
        while (s < n) {
            ++incr;
            bottom += incr;
            s += bottom;
        }
        if (s == n) {
            return bottom;
        }
        s -= bottom;
        bottom -= incr;
        int extra = 0;
        while (s < n) {
            ++extra;
            s += extra;
        }
        return extra + bottom;
    }
}