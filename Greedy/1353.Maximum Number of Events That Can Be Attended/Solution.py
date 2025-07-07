class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        mp = defaultdict(list)
        n = 0
        for a, b in events:
            mp[a].append(b)
            n = max(n, b)
        q = []
        ans = 0
        for i in range(n + 1):
            if i in mp:
                for v in mp[i]:
                    heapq.heappush(q, (v, i))
            while q and q[0][0] < i:
                heapq.heappop(q)
            if q and q[0][1] <= i:
                ans += 1
                heapq.heappop(q)
        return ans
