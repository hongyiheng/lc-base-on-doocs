class Solution:
    def largestGoodInteger(self, num: str) -> str:
        ans, cur, cnt = -1, 0, 0
        cnt = 0
        for c in num:
            if cur == int(c):
                cnt += 1
            else:
                cur = int(c)
                cnt = 1
            if cnt == 3:
                ans = max(ans, int(c))
        return "" if ans == -1 else str(ans) + str(ans) + str(ans)