class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for (char c : chars.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (String w : words) {
            int[] wc = new int[26];
            boolean flag = true;
            for (char c : w.toCharArray()) {
                if (++wc[c - 'a'] > cnt[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += w.length();
            }
        }
        return ans;
    }
}