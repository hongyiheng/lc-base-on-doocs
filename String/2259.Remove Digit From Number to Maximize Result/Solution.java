class Solution {
    public String removeDigit(String number, char digit) {
        char[] chars = number.toCharArray();
        int n = chars.length;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == digit) {
                if (i < n - 1 && chars[i + 1] > digit) {
                    return number.substring(0, i) + number.substring(i + 1, n);
                }
                idx = i;
            }
        }
        return number.substring(0, idx) + number.substring(idx + 1, n);
    }
}