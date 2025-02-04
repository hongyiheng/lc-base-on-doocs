class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        i, j = 0, 1
        ans = [0] * len(nums)
        for v in nums:
            if v % 2 == 0:
                ans[i] = v
                i += 2
            else:
                ans[j] = v
                j += 2
        return ans
        