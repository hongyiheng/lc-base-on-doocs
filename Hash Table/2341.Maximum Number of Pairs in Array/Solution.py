class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        cnt = [0] * 110
        for v in nums:
            cnt[v] += 1
        ans = [0, 0]
        for i, v in enumerate(cnt):
            ans[0] += v // 2
            ans[1] += v % 2
        return ans
