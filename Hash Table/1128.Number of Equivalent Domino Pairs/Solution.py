class Solution:
    def numEquivDominoPairs(self, dominoes: List[List[int]]) -> int:
        mp = defaultdict(int)
        ans = 0
        for a, b in dominoes:
            v = (1 << a) | (1 << b)
            ans += mp[v]
            mp[v] += 1
        return ans
