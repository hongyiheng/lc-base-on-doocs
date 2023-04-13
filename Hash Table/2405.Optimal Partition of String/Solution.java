class Solution {
    public int partitionString(String s) {
        int ans = 0, mask = 0;
        for (char c : s.toCharArray()) {
            int v = c - 'a';
            if ((mask >> v & 1) == 1) {
                ans++;
                mask = 0;
            }
            mask |= 1 << v;
        }
        return mask == 0 ? ans : ans + 1;
    }
}
