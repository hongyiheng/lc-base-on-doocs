class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        ans = []
        s = 0
        for i, v in enumerate(nums):
            s <<= 1
            s |= v
            ans.append(not s % 5)
        return ans