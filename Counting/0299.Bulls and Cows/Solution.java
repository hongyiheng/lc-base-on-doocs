class Solution {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        for (char c : secret.toCharArray()) {
            cnt[c - '0']++;
        }
        int[] ans = new int[]{0, 0};
        for (char c : guess.toCharArray()) {
            if (cnt[c - '0'] > 0) {
                cnt[c - '0']--;
                ans[1]++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ans[0]++;
                ans[1]--;
            }
        }
        return ans[0] + "A" + ans[1] + "B";
    }
}