class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stk = [-i for i in stones]
        heapq.heapify(stk)
        while len(stk) > 1:
            x, y = heapq.heappop(stk), heapq.heappop(stk)
            if x != y:
                heapq.heappush(stk, x - y)
        return -heapq.heappop(stk) if stk else 0