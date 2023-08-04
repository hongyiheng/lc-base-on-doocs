class Solution:
    def findPrefixScore(self, nums: List[int]) -> List[int]:
        ans = [nums[0] * 2]
        mx = nums[0]
        for i in range(1, len(nums)):
            mx = max(mx, nums[i])
            ans.append(ans[-1] + nums[i] + mx)
        return ans