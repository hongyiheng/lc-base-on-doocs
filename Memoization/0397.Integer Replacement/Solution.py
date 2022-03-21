class Solution:
    def integerReplacement(self, n: int) -> int:
        mp = dict()

        def dfs(n):
            if n == 1:
                return 0
            if n % 2 == 0:
                if n // 2 in mp:
                    ans = mp[n // 2]
                else:
                    ans = dfs(n // 2)
                    mp[n // 2] = ans
                return 1 + ans
            else:
                if n + 1 in mp:
                    ans1 = mp[n + 1]
                else:
                    ans1 = dfs(n + 1)
                    mp[n + 1] = ans1
                if n - 1 in mp:
                    ans2 = mp[n - 1]
                else:
                    ans2 = dfs(n - 1)
                    mp[n - 1] = ans2
                return 1 + min(ans1, ans2)

        return dfs(n)