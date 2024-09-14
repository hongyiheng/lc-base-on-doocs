class Solution:
    def removeStars(self, s: str) -> str:
        ans = ""
        cnt = 0
        for i in range(len(s) - 1, -1, -1):
            c = s[i]
            if c == '*':
                cnt += 1
            else:
                if cnt == 0:
                    ans = c + ans
                else:
                    cnt -= 1
        return ans