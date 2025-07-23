class Solution {
    public int maximumGain(String s, int x, int y) {
        char a = 'a', b = 'b';
        if (x < y) {
            b = 'a';
            a = 'b';
            int z = x;
            x = y;
            y = z;
        }
        int ans = 0, cnt1 = 0, cnt2 = 0;
        for (char c : s.toCharArray()) {
            if (c == a) {
                cnt1++;
            } else if (c == b) {
                if (cnt1 > 0) {
                    cnt1--;
                    ans += x;
                } else {
                    cnt2++;
                }
            } else {
                ans += Math.min(cnt1, cnt2) * y;
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        return ans + Math.min(cnt1, cnt2) * y;
    }
}