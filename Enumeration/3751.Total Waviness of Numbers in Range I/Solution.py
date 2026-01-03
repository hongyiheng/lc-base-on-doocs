class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        def f(x):
            s = str(x)
            ans = 0
            for i in range(1, len(s) - 1):
                if (s[i - 1] < s[i] > s[i + 1]) or (s[i - 1] > s[i] < s[i + 1]):
                    ans += 1
            return ans

        ans = 0
        for v in range(num1, num2 + 1):
            ans += f(v)
        return ans