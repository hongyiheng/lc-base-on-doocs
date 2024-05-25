class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        def check(a, b):
            if a == "":
                return b
            if len(a) != len(b):
                return a if len(a) < len(b) else b
            for c, d in zip(a, b):
                if c != d:
                    return a if c < d else b
            return a

        ans = ""
        l = cnt = 0
        for r in range(len(s)):
            cnt += 1 if s[r] == '1' else 0
            while cnt == k:
                ans = check(ans, s[l:r + 1])
                cnt -= 1 if s[l] == '1' else 0
                l += 1
        return ans
