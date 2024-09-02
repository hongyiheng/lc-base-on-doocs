class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        def f(t):
            n = len(answerKey)
            l = r = 0
            ans = d = 0
            while r < n:
                if answerKey[r] != t:
                    d += 1
                while d > k:
                    if answerKey[l] != t:
                        d -= 1
                    l += 1
                ans = max(ans, r - l + 1)
                r += 1
            return ans

        return max(f("T"), f("F"))