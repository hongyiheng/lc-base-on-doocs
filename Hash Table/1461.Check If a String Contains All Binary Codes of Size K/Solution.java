class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> cnt = new HashSet<>();
        int cur = 0, w = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = (cur << 1) + s.charAt(i) - '0';
            if (++w >= k) {
                cnt.add(cur);
                cur -= (s.charAt(i - k + 1) - '0') << (k - 1);
                w--;
            }
        }
        return cnt.size() == (1 << k);
    }
}
