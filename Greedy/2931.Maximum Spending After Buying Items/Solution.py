class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        m, n = len(values), len(values[0])
        ans = 0
        q = [(values[i][-1], i, n - 1) for i in range(m)]
        heapq.heapify(q)
        for i in range(m * n):
            v, j, idx = heapq.heappop(q)
            ans += v * (i + 1)
            if idx > 0:
                heapq.heappush(q, (values[j][idx - 1], j, idx - 1))
        return ans