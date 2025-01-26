class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(i, s, p, skip):
            if s >= target or i >= len(candidates):
                if s == target:
                    ans.append(p[::])
                return
            if skip and candidates[i] == candidates[i - 1]:
                return dfs(i + 1, s, p, True)

            p.append(candidates[i])
            s += candidates[i]
            dfs(i + 1, s, p, False)
            s -= candidates[i]
            p.pop()
            dfs(i + 1, s, p, True)

        candidates.sort()
        ans = []
        dfs(0, 0, [], False)
        return ans



