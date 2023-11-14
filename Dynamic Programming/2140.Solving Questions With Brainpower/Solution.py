class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        f = [0] * (n + 1)
        for i in range(1, n + 1):
            f[i] = max(f[i - 1], f[i])
            v, d = questions[i - 1]
            j = min(i + d, n)
            f[j] = max(f[j], f[i - 1] + v)
        return f[n]