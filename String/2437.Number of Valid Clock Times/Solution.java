class Solution {
    public int countTime(String time) {
        int ans = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            ans = 24;
        } else if (time.charAt(0) == '?') {
            ans = time.charAt(1) < '4' ? 3 : 2;
        } else if (time.charAt(1) == '?') {
            ans = time.charAt(0) >= '2' ? 4 : 10;
        }
        ans *= time.charAt(3) == '?' ? 6 : 1;
        ans *= time.charAt(4) == '?' ? 10 : 1;
        return ans;
    }
}
