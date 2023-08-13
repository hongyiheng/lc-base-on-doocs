class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        q = []
        for v in nums:
            heappush(q, -v)
        ans = 0
        while k:
            v = -heappop(q)
            ans += v
            v = v // 3 + (1 if v % 3 else 0)
            heappush(q, -v)
            k -= 1
        return ans