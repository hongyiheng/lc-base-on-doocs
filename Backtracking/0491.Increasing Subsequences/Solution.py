class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        ans = []
        s = set()
        n = len(nums)

        def dfs(path, vis, idx):
            if len(path) >= 2:
                h = str(path)
                if h not in s:
                    ans.append(path[::])
                    s.add(h)
            if idx >= n:
                return
            for i in range(idx, n):
                if vis[i]:
                    continue
                if path and path[-1] > nums[i]:
                    continue
                path.append(nums[i])
                vis[i] = True
                dfs(path, vis, i + 1)
                vis[i] = False
                path.pop()

        dfs(list(), [False] * n, 0)
        return ans
