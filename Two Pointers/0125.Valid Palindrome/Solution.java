class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return true;
        }
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(chars[left]) && left < chars.length - 1) {
                left++;
            }
            while (!Character.isLetterOrDigit(chars[right]) && right > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}