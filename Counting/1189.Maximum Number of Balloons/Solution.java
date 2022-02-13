class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        char[] chars = text.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        int ans = Math.min(cnt[0], cnt[1]);
        ans = Math.min(ans, cnt['n' - 'a']);
        ans = Math.min(ans, cnt['l' - 'a'] / 2);
        ans = Math.min(ans, cnt['o' - 'a'] / 2);
        return ans;
    }
}