class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[][] ws = new int[n][26];
        int[] sc = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                ws[i][c - 'a']++;
                sc[i] += score[c - 'a'];
            }
        }
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            int[] tmp = cnt.clone();
            int s = 0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1 && flag) {
                    s += sc[j];
                    for (int k = 0; k < 26; k++) {
                        tmp[k] -= ws[j][k];
                        if (tmp[k] < 0) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}