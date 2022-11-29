class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        cnt = [0] * (1 << 10)
        cnt[0] = 1
        mask = ans = 0
        for c in word:
            mask ^= (1 << (ord(c) - ord('a')))
            ans += cnt[mask]
            for i in range(10):
                ans += cnt[(1 << i) ^ mask]
            cnt[mask] += 1
        return ans
