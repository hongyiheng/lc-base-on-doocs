class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        g = [[inf] * 26 for _ in range(26)]
        for u, v, w in zip(original, changed, cost):
            g[ord(u) - ord('a')][ord(v) - ord('a')] = min(w, g[ord(u) - ord('a')][ord(v) - ord('a')])
        for i in range(26):
            g[i][i] = 0
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    if g[i][k] + g[k][j] < g[i][j]:
                        g[i][j] = g[i][k] + g[k][j]
        ans = 0
        for a, b in zip(source, target):
            if a == b:
                continue
            v = g[ord(a) - ord('a')][ord(b) - ord('a')]
            if v == inf:
                return -1
            ans += v
        return ans