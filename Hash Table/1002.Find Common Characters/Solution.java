class Solution {
    public List<String> commonChars(String[] words) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        for (String s : words) {
            char[] cs = s.toCharArray();
            int[] cur = new int[26];
            for (char c : cs) {
                cur[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == -1 || cnt[i] == cur[i]) {
                    cnt[i] = cur[i];
                } else {
                    cnt[i] = Math.min(cnt[i], cur[i]);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                ans.add(String.valueOf((char)('a' + i)));
                cnt[i]--;
            }
        }
        return ans;
    }
}
