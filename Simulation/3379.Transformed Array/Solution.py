class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        ans = []
        n = len(nums)
        for i, v in enumerate(nums):
            if v == 0:
                ans.append(0)
            else:
                ans.append(nums[(i + v) % n])
        return ans