class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        def dfs(cur, idx):
            nonlocal ans
            a, b = abs(target - cur), abs(target - ans)
            if a < b:
                ans = cur
            if a == b and cur < ans:
                ans = cur
            if cur > target:
                return
            for i in range(idx, len(toppingCosts)):
                dfs(cur + toppingCosts[i], i + 1)
                dfs(cur + 2 * toppingCosts[i], i + 1)

        ans = baseCosts[0]
        for b in baseCosts:
            dfs(b, 0)
        return ans
