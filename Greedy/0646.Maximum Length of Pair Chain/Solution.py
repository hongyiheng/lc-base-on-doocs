class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        def cmp(a, b):
            return a[1] - b[1]

        pairs.sort(key=cmp_to_key(cmp))
        ans, cur = 1, pairs[0][1]
        for p in pairs:
            if p[0] > cur:
                cur = p[1]
                ans += 1
        return ans