class Solution {
    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1 << 10];
        cnt[0] = 1;
        int mask = 0;
        long ans = 0;
        for (char c : word.toCharArray()) {
            mask ^= (1 << (c - 'a'));
            ans += cnt[mask];
            for (int i = 0; i < 10; i++) {
                ans += cnt[mask ^ (1 << i)];
            }
            cnt[mask]++;
        }
        return ans;
    }
}
