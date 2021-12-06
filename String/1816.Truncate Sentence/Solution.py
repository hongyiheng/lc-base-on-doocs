class Solution:
    def truncateSentence(self, s: str, k: int) -> str:
        n, index = len(s), 0
        for i in range(n):
            if k <= 0:
                break
            if s[i] == ' ':
                k -= 1
            else:
                index = i
        return s[:index + 1]
