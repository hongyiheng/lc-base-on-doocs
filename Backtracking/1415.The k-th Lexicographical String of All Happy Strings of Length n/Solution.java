class Solution {

    int n;
    List<String> ans;

    public void dfs(Deque<String> path) {
        if (path.size() == n) {
            ans.add(String.join("", new ArrayList<>(path)));
            return;
        }
        for (String c : new String[]{"a", "b", "c"}) {
            if (!path.isEmpty() && path.peekLast().equals(c)) {
                continue;
            }
            path.addLast(c);
            dfs(path);
            path.pollLast();
        }
    }

    public String getHappyString(int n, int k) {
        this.n = n;
        ans = new ArrayList<>();
        dfs(new ArrayDeque<String>());
        if (ans.size() < k) {
            return "";
        }
        Collections.sort(ans);
        return ans.get(k - 1);
    }
}