class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        m = len(isConnected)
        p = [i for i in range(m)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        for i in range(m):
            for j in range(m):
                if isConnected[i][j] == 1:
                    p[find(i)] = find(j)
        ans = 0
        for i in range(m):
            if p[i] == i:
                ans += 1
        return ans