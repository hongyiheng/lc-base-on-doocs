class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int a = 0, b = 0;
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(0)) {
                a++;
            }
            if (c == pattern.charAt(1)) {
                b++;
            }
        }
        long ans = Math.max(a, b);
        for (char c : text.toCharArray()) {
            if (c == pattern.charAt(1)) {
                b--;
            }
            if (c == pattern.charAt(0)) {
                ans += b;
            }
        }
        return ans;
    }
}