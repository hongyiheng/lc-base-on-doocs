class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || used[j]) {
                    continue;
                }
                if (words[i].indexOf(words[j]) != -1) {
                    ans.add(words[j]);
                    used[j] = true;
                }
            }
        }
        return ans;
    }
}