class Solution:
    def longestBalancedSubstring(self, s: str) -> int:
        ans = 1
        for mask in range(1, 8):
            chars = [i for i in range(3) if mask >> i & 1]
            zero = tuple(0 for _ in chars)
            cnt = [0] * 3
            first = {zero: -1}
            for i, c in enumerate(s):
                j = ord(c) - ord('a')
                if mask >> j & 1:
                    cnt[j] += 1
                    base = cnt[chars[0]]
                    key = tuple(cnt[ch] - base for ch in chars)
                    if key in first:
                        ans = max(ans, i - first[key])
                    else:
                        first[key] = i
                else:
                    cnt = [0] * 3
                    first = {zero: i}
        return ans