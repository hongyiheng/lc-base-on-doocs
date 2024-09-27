class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] q = new int[3], t = new int[3];
        Arrays.fill(t, -k);
        for (char c : s.toCharArray()) {
            q[c - 'a']++;
            t[c - 'a']++;
        }
        for (int v : t) {
            if (v < 0) {
                return -1;
            }
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, s, t)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return s.length() - r;
    }

    public boolean check(int x, String s, int[] t) {
        int[] cnt = new int[3];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt[s.charAt(r) - 'a']++;
            if (r - l + 1 == x) {
                boolean hit = true;
                for (int i = 0; i < 3; i++) {
                    if (cnt[i] > t[i]) {
                        hit = false;
                    }
                }
                if (hit) {
                    return true;
                }
                cnt[s.charAt(l++) - 'a']--;
            }
        }

        return false;
    }
}