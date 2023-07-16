class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        char[] cs = s.toCharArray();
        ans.append(cs[0]);
        int cnt = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt < 3) {
                ans.append(cs[i]);
            }
        }
        return ans.toString();
    }
}