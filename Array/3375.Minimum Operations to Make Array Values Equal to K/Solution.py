class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = last = 0
        for v in nums:
            if v < k:
                return -1
            elif v > k and v != last:
                ans += 1
            last = v
        return ans