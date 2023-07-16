class Solution:
    def makeFancyString(self, s: str) -> str:
        ans = [s[0]]
        cnt = 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                cnt += 1
            else:
                cnt = 1
            if cnt < 3:
                ans.append(s[i])
        return "".join(ans)