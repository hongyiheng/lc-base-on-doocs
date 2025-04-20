class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        cnt = Counter(answers)
        ans = 0
        for k in cnt.keys():
            v = cnt[k]
            ans += (v + k) // (k + 1) * (k + 1)
        return ans