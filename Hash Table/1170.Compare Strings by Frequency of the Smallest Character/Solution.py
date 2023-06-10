class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        def f(s):
            cnt = [0] * 26
            for c in s:
                cnt[ord(c) - ord('a')] += 1
            for v in cnt:
                if v:
                    return v
            return 0

        vs = [f(w) for w in words]
        ans = [0] * len(queries)
        for i, q in enumerate(queries):
            cur = f(q)
            for v in vs:
                ans[i] += 1 if v > cur else 0
        return ans
