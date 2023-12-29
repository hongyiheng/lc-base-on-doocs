class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length(), ans = 0;
        Set<Character> vs = new HashSet();
        for (char v : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            vs.add(v);
        }
        for (int w = 2; w <= n; w += 2) {
            int l = 0, r = 0;
            int v = 0, c = 0;
            while (r < n) {
                if (vs.contains(s.charAt(r))) {
                    v++;
                } else {
                    c++;
                }
                if (r - l + 1 == w) {
                    if (v == c && (v * c) % k == 0) {
                        ans++;
                    }
                    if (vs.contains(s.charAt(l))) {
                        v--;
                    } else {
                        c--;
                    }
                    l++;
                }
                r++;
            }
        }
        return ans;
    }
}