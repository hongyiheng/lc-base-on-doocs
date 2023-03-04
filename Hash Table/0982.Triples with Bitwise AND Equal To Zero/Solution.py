class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        cnt = [0] * (1 << 16)
        for i in nums:
            for j in nums:
                cnt[i & j] += 1
        ans = 0
        for k in nums:
            for i, v in enumerate(cnt):
                if k & i == 0:
                    ans += v
        return ans