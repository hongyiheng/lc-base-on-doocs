class Solution {
    Set<String> ans = new HashSet<>();

    public void dfs(String s) {
        int j = s.indexOf("}");
        if (j == -1) {
            ans.add(s);
            return;
        }
        int i = j - 1;
        while (i >= 0 && s.charAt(i) != '{') {
            i--;
        }
        String pre = s.substring(0, i), tail = s.substring(j + 1);
        for (String v : s.substring(i + 1, j).split(",")) {
            dfs(pre + v + tail);
        }
    }

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }
}