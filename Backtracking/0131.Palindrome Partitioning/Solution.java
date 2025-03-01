class Solution {

    List<List<String>> ans = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, "", new ArrayDeque<>());
        return ans;
    }

    public void dfs(int i, String word, Deque<String> path) {
        if (i >= s.length()) {
            if ("".equals(word)) {
                ans.add(new ArrayList(path));
            }
            return;
        }
        word += s.charAt(i);
        if (check(word)) {
            path.add(word);
            dfs(i + 1, "", path);
            path.pollLast();
        }
        dfs(i + 1, word, path);
    }

    public boolean check(String word) {
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (word.charAt(l++) != word.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}