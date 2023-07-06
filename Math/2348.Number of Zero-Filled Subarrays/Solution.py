class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        ans = cnt = 0
        for v in nums:
            if v == 0:
                cnt += 1
                ans += cnt
            else:
                cnt = 0
        return ans