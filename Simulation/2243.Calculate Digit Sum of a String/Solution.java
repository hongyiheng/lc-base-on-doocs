class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int cnt = 0, cur = 0;
        for (char c : s.toCharArray()) {
            cur += c - '0';
            if (++cnt == k) {
                ans.append(String.valueOf(cur));
                cnt = 0;
                cur = 0;
            }
        }
        if (cnt > 0) {
            ans.append(String.valueOf(cur));
        }
        return digitSum(ans.toString(), k);
    }
}