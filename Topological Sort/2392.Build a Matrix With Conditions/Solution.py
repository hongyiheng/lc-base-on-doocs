class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        def topo_sort(k, arr):
            ind = [0] * k
            g = defaultdict(list)
            for u, v in arr:
                u, v = u - 1, v - 1
                g[u].append(v)
                ind[v] += 1
            q = deque()
            for i, v in enumerate(ind):
                if v == 0:
                    q.append(i)
            ans = []
            while q:
                u = q.popleft()
                ans.append(u)
                for v in g[u]:
                    ind[v] -= 1
                    if ind[v] == 0:
                        q.append(v)
            return ans

        row = topo_sort(k, rowConditions)
        col = topo_sort(k, colConditions)
        if len(row) < k or len(col) < k:
            return []
        pos = [0] * k
        for i in range(k):
            pos[col[i]] = i
        ans = [[0] * k for _ in range(k)]
        for i in range(k):
            ans[i][pos[row[i]]] = row[i] + 1
        return ans
