class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(i, s, path):
            if i == len(candidates) or s >= target:
                if s == target:
                    ans.append(path[::])
                return
            path.append(candidates[i])
            dfs(i, s + candidates[i], path)
            path.pop()
            dfs(i + 1, s, path)

        ans = []
        dfs(0, 0, [])
        return ans