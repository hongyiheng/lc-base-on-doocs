class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            cnt[i]--;
            Set<Integer> s = new HashSet<>();
            for (int v : cnt) {
                if (v != 0) {
                    s.add(v);
                }
            }
            if (s.size() == 1) {
                return true;
            }
            cnt[i]++;
        }
        return false;
    }
}