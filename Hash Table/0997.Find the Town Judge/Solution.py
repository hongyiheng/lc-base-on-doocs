class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        q = [[0] * 2 for _ in range(n + 1)]
        for u, v in trust:
            q[u][0] += 1
            q[v][1] += 1
        for i, v in enumerate(q):
            if i == 0:
                continue
            if v[0] == 0 and v[1] == n - 1:
                return i
        return -1