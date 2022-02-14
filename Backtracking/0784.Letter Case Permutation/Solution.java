class Solution {
    List<String> ans;
    int n;
    String s;

    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        n = s.length();
        this.s = s;
        backTracking(new StringBuilder(), 0);
        return ans;
    }

    public void backTracking(StringBuilder path, int cur) {
        if (path.length() == n) {
            ans.add(path.toString());
            return;
        }
        path.append(s.charAt(cur));
        backTracking(path, cur + 1);
        path.deleteCharAt(path.length() - 1);
        if (!Character.isDigit(s.charAt(cur))) {
            char c = s.charAt(cur) - 'a' >= 0 ? (char)(s.charAt(cur) - 32) : (char)(s.charAt(cur) + 32);
            path.append(c);
            backTracking(path, cur + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}