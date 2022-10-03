class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        ans = idx = 0
        n = len(s)
        while idx < n:
            if s[idx] == '1':
                ans += 1
                while idx < n and s[idx] == '1':
                    idx += 1
            else:
                idx += 1
        return ans <= 1
