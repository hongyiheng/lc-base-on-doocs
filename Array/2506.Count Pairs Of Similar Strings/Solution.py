class Solution:
    def similarPairs(self, words: List[str]) -> int:
        g = defaultdict(int)
        ans = 0
        for w in words:
            v = 0
            for c in w:
                v |= (1 << (ord(c) - ord('a')))
            ans += g[v]
            g[v] += 1
        return ans
