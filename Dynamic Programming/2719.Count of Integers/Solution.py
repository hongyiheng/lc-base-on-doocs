class Solution:
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        @cache
        def dfs(s, i, cnt, is_limit):
            if cnt > max_sum:
                return 0
            if i == len(s):
                return int(cnt >= min_sum)
            res = 0
            up = int(s[i]) if is_limit else 9
            for d in range(up + 1):
                res += dfs(s, i + 1, cnt + d, is_limit and d == up)
            return res % MOD

        MOD = 10 ** 9 + 7
        ans = dfs(num2, 0, 0, True) - dfs(num1, 0, 0, True)
        s = 0
        for c in num1:
            s += ord(c) - ord('0')
        ans += 1 if min_sum <= s <= max_sum else 0
        return ans % MOD
