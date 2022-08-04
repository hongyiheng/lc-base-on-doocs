class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        n, s, cur = len(nums), sum(nums), 0
        nums.sort()
        ans = []
        for i in range(n - 1, -1, -1):
            if cur > s:
                break
            cur += nums[i]
            s -= nums[i]
            ans.append(nums[i])
        return ans