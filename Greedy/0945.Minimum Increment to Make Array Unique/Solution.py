class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        cnt = [0] * 110000
        for v in nums:
            cnt[v] += 1
        s = ans = 0
        for i in range(110000):
            if cnt[i] >= 1:
                s += cnt[i] - 1
            elif s:
                s -= 1
            ans += s
        return ans
