class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(nums)
        pre = [0] * n
        for i in range(1, n):
            pre[i] = pre[i - 1] + (1 if nums[i - 1] % 2 == nums[i] % 2 else 0)
        return [pre[i] == pre[j] for i, j in queries]
