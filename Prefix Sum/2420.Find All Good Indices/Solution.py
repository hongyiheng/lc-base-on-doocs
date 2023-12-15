class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        down, up = [1] * n, [1] * n
        for i in range(1, n):
            if nums[i] <= nums[i - 1]:
                down[i] = down[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if nums[i] <= nums[i + 1]:
                up[i] = up[i + 1] + 1
        return [i for i in range(1, n - 1) if up[i + 1] >= k and down[i - 1] >= k]