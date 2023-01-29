class Solution:
    def minInsertions(self, s: str) -> int:
        ans = l = i = 0
        n = len(s)
        while i < n:
            if s[i] == '(':
                l += 1
            else:
                cnt = 1
                while i + 1 < n and s[i + 1] == ')':
                    cnt += 1
                    i += 1
                if cnt % 2 != 0:
                    ans += 1
                    cnt += 1
                l -= cnt // 2
                if l < 0:
                    ans += abs(l)
                    l = 0
            i += 1
        if l:
            ans += 2 * l
        return ans