class Solution {
    public int maxDepth(String s) {
        int cur = 0, ans = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                cur++;
            } else if (c == ')') {
                cur--;
            }
            ans = Math.max(cur, ans);
        }
        return ans;
    }
}