class Solution:
    def similarPairs(self, words: List[str]) -> int:
        mp = defaultdict(int)
        ans = 0
        for w in words:
            mask = 0
            for c in w:
                mask |= (1 << (ord(c) - ord('a')))
            ans += mp[mask]
            mp[mask] += 1
        return ans