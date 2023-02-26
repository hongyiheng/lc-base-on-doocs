class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        s = 0
        for i in range(n):
            s += nums[i]
            if i >= 2 * k:
                ans[i - k] = s // (2 * k + 1)
                s -= nums[i - 2 * k]
        return ans