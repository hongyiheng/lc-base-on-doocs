class Solution:
    def minLength(self, s: str) -> int:
        def dfs(s):
            n = len(s)
            for i in range(n):
                if i + 1 < n and s[i:i + 2] in {'AB', 'CD'}:
                    return dfs(s[:i] + s[i + 2:])
            return s

        return len(dfs(s))

