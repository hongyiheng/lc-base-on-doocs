class Solution {

    Set<String> t = new HashSet(Arrays.asList("AB", "CD"));

    public String dfs(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (t.contains(s.substring(i, i + 2))) {
                return dfs(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }

    public int minLength(String s) {
        return dfs(s).length();
    }
}