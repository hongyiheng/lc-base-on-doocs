class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        s = 0
        for i, v in enumerate(nums):
            if v > 0:
                s += v
            else:
                nums[i] = -v
        nums.sort()
        q = [(0, 0)]
        for _ in range(k - 1):
            cur, i = heapq.heappop(q)
            if i < len(nums):
                heapq.heappush(q, (cur + nums[i], i + 1))
                if i:
                    heapq.heappush(q, (cur + nums[i] - nums[i - 1], i + 1))
        return s - q[0][0]