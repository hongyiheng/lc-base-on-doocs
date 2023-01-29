class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums)
        ans = ["0"] * n
        for i in range(n):
            if nums[i][i] == '0':
                ans[i] = "1"
        return "".join(ans)