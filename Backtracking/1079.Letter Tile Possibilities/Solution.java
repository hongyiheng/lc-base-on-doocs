class Solution {

    int[] cnt = new int[26];

    public int numTilePossibilities(String tiles) {
        for (char c : tiles.toCharArray()) {
            cnt[c - 'A']++;
        }        
        return dfs();
    }

    public int dfs() {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                ans++;
                cnt[i]--;
                ans += dfs();
                cnt[i]++;
            }
        }
        return ans;
    }
}