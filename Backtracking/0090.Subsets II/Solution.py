class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans, path = set(), []
        n = len(nums)

        def dfs(path, idx, cur):
            nonlocal ans, nums, n
            if idx == n:
                ans.add(tuple(path[::]))
                return
            for i in range(cur, n):
                path.append(nums[i])
                dfs(path, idx + 1, i + 1)
                path.pop()
                dfs(path, idx + 1, i + 1)

        dfs(path, 0, 0)
        return list(ans)