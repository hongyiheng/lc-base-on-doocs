class Solution:
    def maxScore(self, s: str) -> int:
        n = len(s)
        zero = [0] * n
        one = 0
        for i in range(n):
            if i > 0:
                zero[i] = zero[i - 1]
            if s[i] == "0":
                zero[i] += 1
            else:
                one += 1
        ans = 0
        for i in range(n - 1):
            left = zero[i]
            right = one - (i + 1 - zero[i])
            ans = max(ans, left + right)
        return ans