class Solution:
    def makeIntegerBeautiful(self, n: int, target: int) -> int:
        s = ['0'] + list(str(n))
        cnt, n = 0, len(s)
        for c in s:
            cnt += int(c)
        ans = 0
        for i in range(n - 1, 0, -1):
            if cnt <= target:
                break
            if s[i] != 0:
                idx = 1 if n - i - 1 == 0 else 10 ** (n - i - 1)
                ans += (10 - int(s[i])) * idx
                cnt -= (int(s[i]) - 1)
                s[i] = '0'
                s[i - 1] = str(int(s[i - 1]) + 1)
        return ans
