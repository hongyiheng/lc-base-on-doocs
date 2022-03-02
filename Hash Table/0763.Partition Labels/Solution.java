class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        Set<Character> cs = new HashSet<>();
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            cs.add(chars[i]);
            cnt[chars[i] - 'a']--;
            if (cnt[chars[i] - 'a'] == 0 && check(cnt, cs)) {
                ans.add(i - cur + 1);
                cur = i + 1;
                cs.clear();
            }
        }
        return ans;
    }

    public boolean check(int[] cnt, Set<Character> chars) {
        for (char c : chars) {
            if (cnt[c - 'a'] != 0) {
                return false;
            }
        }
        return true;
    }
}