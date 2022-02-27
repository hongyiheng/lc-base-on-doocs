class Solution:
    def optimalDivision(self, nums: List[int]) -> str:
        n = len(nums)
        ans = ""
        if n == 1:
            ans = str(nums[0])
        elif n == 2:
            ans = str(nums[0]) + "/" + str(nums[1])
        else:
            ans = str(nums[0]) + "/(" + str(nums[1])
            for i in range(2, n):
                ans += "/" + str(nums[i])
            ans += ")"
        return ans
