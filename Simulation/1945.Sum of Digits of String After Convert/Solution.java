class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        int ans = 0;
        String ss = sb.toString();
        while (k-- > 0) {
            int cur = 0;
            for (char c : ss.toCharArray()) {
                cur += c - '0';
            }
            ans = cur;
            ss = String.valueOf(cur);
        }
        return ans;
    }
}
