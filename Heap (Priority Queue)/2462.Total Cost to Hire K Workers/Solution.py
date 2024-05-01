class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        if n <= 2 * candidates:
            costs.sort()
            return sum(costs[:k])
        q = []
        for i in range(candidates):
            if i > n - i - 1:
                break
            heapq.heappush(q, [costs[i], i])
            if i != n - i - 1:
                heapq.heappush(q, [costs[n - i - 1], n - i - 1])
        l, r = candidates, n - candidates - 1
        ans = 0
        while k:
            v, i = heapq.heappop(q)
            if l <= r:
                if i > r:
                    heapq.heappush(q, [costs[r], r])
                    r -= 1
                else:
                    heapq.heappush(q, [costs[l], l])
                    l += 1
            ans += v
            k -= 1
        return ans




