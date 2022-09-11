class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        n = len(quality)
        ds = [[0] * 2 for _ in range(n)]
        for i in range(n):
            ds[i][0] = wage[i] / quality[i]
            ds[i][1] = quality[i]
        ds.sort(key=lambda x:x[0])
        ans = float('inf')
        q = []
        cnt = 0
        for i in range(n):
            cnt += ds[i][1]
            heapq.heappush(q, -ds[i][1])
            if len(q) > k:
                cnt += heapq.heappop(q)
            if len(q) == k:
                ans = min(ans, cnt * ds[i][0])
        return ans