class Solution:
    def numSteps(self, s: str) -> int:
        ans = 0
        add = False
        for i in range(len(s) - 1, 0, -1):
            v = 1 if add else 0
            v += 1 if s[i] == '1' else 0
            if v == 0:
                ans += 1
            elif v == 1:
                ans += 2
                v += 1
            elif v == 2:
                ans += 1
            add = v == 2
        return ans + 1 if add else ans

