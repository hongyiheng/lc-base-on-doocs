class Solution {
    public String addSpaces(String s, int[] spaces) {
        List<String> ans = new ArrayList<>();
        int last = 0;
        for (int v : spaces) {
            ans.add(s.substring(last, v));
            last = v;
        }
        ans.add(s.substring(last));
        return String.join(" ", ans);
    }
}