class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        @cache
        def dfs(i, mask, is_limit, is_num):
            if i == len(s):
                return 1 if is_num else 0
            ans = 0
            if not is_num:
                ans = dfs(i + 1, mask, False, False)
            low = 0 if is_num else 1
            up = int(s[i]) if is_limit else 9
            for d in range(low, up + 1):
                if mask >> d & 1 == 0:
                    ans += dfs(i + 1, mask | 1 << d, is_limit and d == up, True)
            return ans

        s = str(n)
        return dfs(0, 0, True, False)