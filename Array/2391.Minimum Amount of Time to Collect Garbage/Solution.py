class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        ans = 0
        g = defaultdict(int)
        for i, w in enumerate(garbage):
            for c in w:
                g[c] = i
            ans += len(w)
        for i, v in enumerate(travel):
            for d in g.values():
                if d > i:
                    ans += v
        return ans