class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        if num == 0:
            return True
        s = str(num)
        cur, ans = 1, 0
        for i in range(len(s) - 1, -1, -1):
            if ans == 0 and s[i] == '0':
                return False
            ans += int(s[i]) * cur
            cur *= 10
        return str(ans)[-1] != '0'