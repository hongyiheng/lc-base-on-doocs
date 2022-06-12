class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0, r = n - 1;
        char[] chars = directions.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'L') {
                l++;
            } else {
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == 'R') {
                r--;
            } else {
                break;
            }
        }
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (chars[i] == 'S') {
                cnt++;
            }
        }
        return r - l + 1 - cnt;
    }
}