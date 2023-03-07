class Solution:
    def braceExpansionII(self, expression: str) -> List[str]:
        ans = set()

        def dfs(s):
            j = s.find("}")
            if j == -1:
                ans.add(s)
                return
            i = s.rfind("{", 0, j - 1)
            pre, tail = s[:i], s[j + 1:]
            for v in s[i + 1:j].split(","):
                dfs(pre + v + tail)

        dfs(expression)
        return sorted(ans)