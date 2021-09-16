class Solution {
    public boolean checkZeroOnes(String s) {
        int len0 = 0, len1 = 0;
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                len0 = Math.max(len0, ++cnt0);
                cnt1 = 0;
            } else {
                len1 = Math.max(len1, ++cnt1);
                cnt0 = 0;
            }
        }
        return len1 > len0;
    }
}