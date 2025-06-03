class Solution:
    def findCommonResponse(self, responses: List[List[str]]) -> str:
        mx = 1
        mx_w = []
        g = defaultdict(int)
        for r in responses:
            s = set(r)
            for w in s:
                g[w] += 1
                if mx < g[w]:
                    mx = g[w]
                    mx_w = []
                if mx == g[w]:
                    mx_w.append(w)
        mx_w.sort()
        return mx_w[0]

