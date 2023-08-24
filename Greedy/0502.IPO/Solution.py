class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        cp = [(c, p) for p, c in zip(profits, capital)]
        cp.sort(key=lambda x:x[0])
        q = []
        i, n = 0, len(profits)
        while k:
            while i < n and cp[i][0] <= w:
                heapq.heappush(q, -cp[i][1])
                i += 1
            if not q:
                break
            w -= heapq.heappop(q)
            k -= 1
        return w
