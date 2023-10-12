class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long lcm = 1L * divisor1 * divisor2 / gcd(divisor1, divisor2);
        long l = 0, r = 0x3f3f3f3f * 2;
        while (l < r) {
            long mid = l + r >> 1;
            long cnt1 = mid - mid / divisor1, cnt2 = mid - mid / divisor2;
            long common = mid - mid / lcm;
            if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && common >= uniqueCnt1 + uniqueCnt2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}