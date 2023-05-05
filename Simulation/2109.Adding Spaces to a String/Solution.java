class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int last = 0;
        for (int v : spaces) {
            ans.append(s.substring(last, v));
            last = v;
            ans.append(" ");
        }
        if (last != s.length()) {
            ans.append(s.substring(last));
        }
        return ans.toString();
    }
}
