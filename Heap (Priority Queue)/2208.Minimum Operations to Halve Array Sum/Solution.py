class Solution:
    def halveArray(self, nums: List[int]) -> int:
        s = 0
        q = []
        for v in nums:
            s += v
            heapq.heappush(q, -v)
        t, cur, ans = s / 2, 0, 0
        while cur < t:
            v = -heapq.heappop(q) / 2
            cur += v
            heapq.heappush(q, -v)
            ans += 1
        return ans