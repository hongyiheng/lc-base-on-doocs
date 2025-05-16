class Solution {

    private String[] words;
    private int[] groups;
    private int n;
    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        this.words = words;
        this.groups = groups;
        this.n = words.length;
        List<String> ans = new ArrayList<>();
        int mx = 0;
        for (int i = 0; i < n; i++) {
            List<String> cur = new ArrayList<>();
            cur.add(words[i]);
            List<String> dfsResult = dfs(i + 1, i);
            cur.addAll(dfsResult);
            if (cur.size() > mx) {
                ans = cur;
                mx = cur.size();
            }
        }
        return ans;
    }

    private boolean check(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff <= 1;
    }

    private List<String> dfs(int i, int p) {
        String key = i + "," + p;
        if (cache.containsKey(key)) {
            return new ArrayList<>(cache.get(key));
        }
        if (i == n) {
            return new ArrayList<>();
        }
        List<String> ans = dfs(i + 1, p);
        if (groups[i] != groups[p] && words[i].length() == words[p].length() && check(words[i], words[p])) {
            List<String> ans2 = dfs(i + 1, i);
            if (ans2.size() + 1 > ans.size()) {
                List<String> newAns = new ArrayList<>();
                newAns.add(words[i]);
                newAns.addAll(ans2);
                cache.put(key, newAns);
                return newAns;
            }
        }
        cache.put(key, ans);
        return new ArrayList<>(ans);
    }
}