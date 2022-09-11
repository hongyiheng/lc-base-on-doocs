class Solution {
    public String stringShift(String s, int[][] shift) {
        int cnt = 0;
        for (int[] v : shift) {
            cnt = v[0] == 0 ? cnt + v[1] : cnt - v[1];
        }
        int n = s.length();
        while (cnt < n) {
            cnt += n;
        }
        cnt = cnt % n;
        return s.substring(cnt) + s.substring(0, cnt);
    }
}