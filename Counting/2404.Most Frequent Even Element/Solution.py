class Solution:
    def mostFrequentEven(self, nums: List[int]) -> int:
        cnt = [0] * 100001
        for v in nums:
            cnt[v] += 1
        ans, mx = -1, 0
        for i, v in enumerate(cnt):
            if v > mx and i % 2 == 0:
                ans = i
                mx = v
        return ans
