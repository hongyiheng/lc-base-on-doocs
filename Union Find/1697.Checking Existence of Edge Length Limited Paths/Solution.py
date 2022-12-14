class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        edgeList.sort(key=lambda x: x[2])
        queries = [(i, q[0], q[1], q[2]) for i, q in enumerate(queries)]
        queries.sort(key=lambda x: x[3])
        ans = [False] * len(queries)
        p = list(range(n))
        i = 0
        for j, u, v, w in queries:
            while i < len(edgeList) and edgeList[i][2] < w:
                p[find(edgeList[i][0])] = find(edgeList[i][1])
                i += 1
            ans[j] = find(u) == find(v)
        return ans
