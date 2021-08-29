class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return canJump(s, left, right - 1) || canJump(s, left + 1, right);
            } else {
                ++left;
                --right;
            }
        }
        return true;
    }

    public boolean canJump(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}