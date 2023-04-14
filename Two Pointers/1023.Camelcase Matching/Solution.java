class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = pattern.length();
        List<Boolean> ans = new ArrayList<>();
        for (String s : queries) {
            int i = 0, j = 0;
            while (i < n) {
                if (j >= s.length()) {
                    break;
                }
                if (pattern.charAt(i) == s.charAt(j)) {
                    i++;
                } else if (Character.isUpperCase(s.charAt(j))) {
                    break;
                }
                j++;
            }
            while (j < s.length() && !Character.isUpperCase(s.charAt(j))) {
                j++;
            }
            ans.add(i == n && j == s.length());
        }
        return ans;
    }
}
