class Solution {
    public int possibleStringCount(String word) {
        int ans = 1, msk = 0;
        for (char c : word.toCharArray()) {
            int v = c - 'a';
            if ((msk >> v & 1) != 0) {
                ans++;
            }
            msk = 1 << v;
        }
        return ans;
    }
}