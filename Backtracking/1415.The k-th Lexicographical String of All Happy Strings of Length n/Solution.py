class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        def dfs(path):
            if len(path) == n:
                ans.append("".join(path))
                return
            for c in ['a', 'b', 'c']:
                if path and path[-1] == c:
                    continue
                path.append(c)
                dfs(path)
                path.pop()

        ans = []
        dfs([])
        if len(ans) < k:
            return ""
        ans.sort()
        return ans[k - 1]
