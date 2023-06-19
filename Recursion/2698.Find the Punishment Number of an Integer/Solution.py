class Solution:
    def punishmentNumber(self, n: int) -> int:
        def dfs(s, t, i, cur):
            if i == len(s) and cur == t:
                return True
            for j in range(i + 1, len(s) + 1):
                if dfs(s, t, j, cur + int(s[i:j])):
                    return True
            return False

        ans = 0
        for i in range(1, n + 1):
            if dfs(str(i * i), i, 0, 0):
                ans += i * i
        return ans
