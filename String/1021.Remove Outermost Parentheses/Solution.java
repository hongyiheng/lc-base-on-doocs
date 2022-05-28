class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();;
        for (char c : chars) {
            if (c == '(') {
                if (cnt++ > 0) {
                    ans.append(c);
                }
            } else {
                if (--cnt > 0) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}