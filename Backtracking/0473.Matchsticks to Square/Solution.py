class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        all = sum(matchsticks)
        if all % 4 != 0:
            return False
        t = all // 4
        if max(matchsticks) > t:
            return False
        n = len(matchsticks)
        matchsticks.sort()
        vis = [False] * n

        def dfs(k, target, idx):
            nonlocal t, matchsticks, n
            if target == 0:
                k -= 1
                if k == 0:
                    return True
                else:
                    return dfs(k, t, n - 1)

            for i in range(idx, -1, -1):
                if target < matchsticks[i] or vis[i]:
                    continue
                vis[i] = True
                if dfs(k, target - matchsticks[i], i - 1):
                    return True
                vis[i] = False
                if target == t:
                    return False
            return False

        return dfs(4, t, n - 1)