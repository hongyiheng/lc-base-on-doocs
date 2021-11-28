class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] ori = new int[26];
        int[] cur = new int[26];
        int n = p.length();
        for (int i = 0; i < n; i++) {
            int index = p.charAt(i) - 'a';
            ori[index] += 1;
        }
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'a';
            cur[index] += 1;
            if (r - l == n) {
                cur[s.charAt(l) - 'a'] -= 1;
                l += 1;
            }
            if (check(ori, cur)) {
                res.add(l);
            }
        }
        return res;
    }

    private boolean check(int[] ori, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (ori[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }
}