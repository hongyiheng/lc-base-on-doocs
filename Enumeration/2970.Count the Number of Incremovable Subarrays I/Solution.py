class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        def check(i, j):
            last = 0
            for k, v in enumerate(nums):
                if i <= k <= j:
                    continue
                if v <= last:
                    return False
                last = v
            return True

        ans, n = 1, len(nums)
        for i in range(n):
            for j in range(i, n):
                if j - i + 1 == n:
                    continue
                if check(i, j):
                    ans += 1
        return ans