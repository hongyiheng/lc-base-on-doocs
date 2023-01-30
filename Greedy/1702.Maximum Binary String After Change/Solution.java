class Solution {
    public String maximumBinaryString(String binary) {
        int cnt = 0, begin = 0x3f3f3f, n = binary.length();
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                begin = Math.min(i, begin);
                cnt++;
            }
        }
        if (cnt <= 1) {
            return binary;
        }
        char[] ans = new char[n];
        Arrays.fill(ans, '1');
        ans[begin + cnt - 1] = '0';
        return new String(ans);
    }
}