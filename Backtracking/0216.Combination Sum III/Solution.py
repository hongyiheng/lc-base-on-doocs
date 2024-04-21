class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        def dfs(i, cnt, s, path):
            if i >= 10 or cnt >= k or s >= n:
                if cnt == k and s == n:
                    ans.append(path[::])
                return
            dfs(i + 1, cnt, s, path)
            path.append(i)
            dfs(i + 1, cnt + 1, s + i, path)
            path.pop()

        ans = []
        dfs(1, 0, 0, [])
        return ans