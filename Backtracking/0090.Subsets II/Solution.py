class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def dfs(i, path):
            if i >= len(nums):
                ans.append(path[::])
                return
            path.append(nums[i])
            dfs(i + 1, path)
            path.pop()
            while i + 1 < len(nums) and nums[i + 1] == nums[i]:
                i += 1
            dfs(i + 1, path)

        nums.sort()
        ans = []
        dfs(0, [])
        return ans