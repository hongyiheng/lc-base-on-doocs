class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        f = [0] * 26
        for c in s:
            v = ord(c) - ord('a')
            f[v] = f[v] + 1
            for i in range(max(0, v - k), min(26, v + k + 1)):
                if i == v:
                    continue
                f[v] = max(f[v], f[i] + 1)
        return max(f)