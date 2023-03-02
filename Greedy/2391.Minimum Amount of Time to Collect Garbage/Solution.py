class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        G = M = P = 0
        for i, w in enumerate(garbage):
            for c in w:
                if c == 'G':
                    G = i
                if c == 'M':
                    M = i
                if c == 'P':
                    P = i
        ans = 0
        for i, w in enumerate(garbage):
            ans += len(w)
            if i < G:
                ans += travel[i]
            if i < M:
                ans += travel[i]
            if i < P:
                ans += travel[i]
        return ans
