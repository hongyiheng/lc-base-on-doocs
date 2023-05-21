class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        events.sort(key=lambda x:x[0])
        q = []
        ans = mx = 0
        for u, v, w in events:
            while q and q[0][0] < u:
                mx = max(mx, heapq.heappop(q)[1])
            ans = max(ans, mx + w)
            heapq.heappush(q, [v, w])
        return ans