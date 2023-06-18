class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length();
        while (i > 0 && num.charAt(i - 1) == '0') {
            i--;
        }
        return num.substring(0, i);
    }
}