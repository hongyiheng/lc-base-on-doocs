class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        cnt = [0] * 1010
        for v in answers:
            cnt[v] += 1
        ans = 0
        for i, v in enumerate(cnt):
            ans += v
            if v % (i + 1):
                ans = ans + (i + 1) - v % (i + 1)
        return ans