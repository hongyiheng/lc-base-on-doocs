class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        q = []
        min_val = float('inf')
        for v in nums:
            if v % 2 != 0:
                v *= 2
            min_val = min(v, min_val)
            heapq.heappush(q, -v)
        ans = float('inf')
        while q and -q[0] % 2 == 0:
            v = -heapq.heappop(q) // 2
            min_val = min(v, min_val)
            heapq.heappush(q, -v)
            ans = min(ans, -q[0] - min_val)
        return ans
