class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        ans = 0
        for i in range(n):
            freq = [0] * 26
            freq_cnt = defaultdict(int)
            for j in range(i, n):
                idx = ord(s[j]) - ord('a')
                old = freq[idx]
                if old > 0:
                    freq_cnt[old] -= 1
                    if freq_cnt[old] == 0:
                        del freq_cnt[old]
                freq[idx] += 1
                new = freq[idx]
                freq_cnt[new] += 1
                if len(freq_cnt) == 1:
                    ans = max(ans, j - i + 1)
        return ans
