class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        s = str(n)

        @cache
        def dfs(i, limit, num):
            if i == len(s):
                return 1 if num else 0
            ans = 0
            if not num:
                ans = dfs(i + 1, False, False)
            up = int(s[i]) if limit else 9
            for v in digits:
                if int(v) > up:
                    break
                ans += dfs(i + 1, limit and int(v) == up, True)
            return ans

        return dfs(0, True, False)
