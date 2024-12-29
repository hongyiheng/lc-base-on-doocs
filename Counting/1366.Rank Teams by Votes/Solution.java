class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] cnt = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                cnt[vote.charAt(i) - 'A'][i]++;
            }
        }
        Character[] cs = new Character[n];
        for (int i = 0; i < n; i++) {
            cs[i] = votes[0].charAt(i);
        }
        Arrays.sort(cs, (a, b) -> {
            int i = a - 'A', j = b - 'A';
            for (int k = 0; k < n; k++) {
                if (cnt[i][k] != cnt[j][k]) {
                    return cnt[j][k] - cnt[i][k];
                }
            }
            return i - j;
        });
        StringBuilder ans = new StringBuilder();
        for (Character c : cs) {
            ans.append(c);
        }
        return ans.toString();
    }
}