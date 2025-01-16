class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = n + 1
        for i in range(n):
            s = nums[i]
            for j in range(i, n):
                s |= nums[j]
                if s >= k:
                    ans = min(ans, j - i + 1)
                    break
        return ans if ans <= n else -1