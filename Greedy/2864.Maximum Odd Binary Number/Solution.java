class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length(), cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            if (cnt > 1) {
                cnt--;
                ans.append('1');
            } else {
                ans.append('0');
            }
        }
        ans.append('1');
        return ans.toString();
    }
}