class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        cnt = [0] * 1010
        for v in nums:
            cnt[v] += 1
        l, r, ans = 0, len(nums), 0
        for v in cnt:
            r -= v
            ans += l * r * v
            l += v
        return ans
