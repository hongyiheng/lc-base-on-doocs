class Solution:
    def longestDecomposition(self, text: str) -> int:
        def dfs(s):
            if not s:
                return 0
            l, r = 0, len(s) - 1
            s1, s2 = "", ""
            while l < r:
                s1 += s[l]
                s2 = s[r] + s2
                if s1 == s2:
                    return 2 + dfs(s[l+1:r])
                l += 1
                r -= 1
            return 1

        return dfs(text)
