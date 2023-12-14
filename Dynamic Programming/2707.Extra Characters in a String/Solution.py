class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        @cache
        def dfs(i):
            if not i:
                return 0
            ans = dfs(i - 1) + 1
            for j in range(i):
                if s[j:i] in d:
                    ans = min(ans, dfs(j))
            return ans

        d = set(dictionary)
        return dfs(len(s))

